function pred_error_swarm(work,typ,LA,LP)
close all
warning off 'parallel:cluster:CannotSaveCorrectly'
workers=str2num(work)
myCluster = parcluster('local');
myCluster.NumWorkers = workers;  % 'Modified' property now TRUE
saveProfile(myCluster);
parpool(myCluster,workers);
format long
load('weighted5_s')
features_n = 5;
types_n = 2^features_n;

 % 'ALL' or 'HYPERCUBE'

global all_ydata
global xdata
global ydata
global PREDICTION_MONTHS
global best_pe
global type
global LAMBDA_A
global LAMBDA_P
%figure(1);
%drawnow
%figure(2);
%drawnow

type=typ
best_pe = Inf;
PREDICTION_MONTHS = 12;
xdata = weighted5_s(1:end-(PREDICTION_MONTHS+1),:);
ydata = weighted5_s(2:end-PREDICTION_MONTHS,:);

all_ydata  = weighted5_s(2:end,:);

%InitialParameters = ones(1,types_n*types_n);
LowerBounds = zeros(1,types_n*types_n);
UpperBounds = ones(1,types_n*types_n);

for i = 1:types_n
   
    InitialParameters(i) = 2;
    LowerBounds(i) = 1;
    UpperBounds(i) = 500;
end



LAMBDAS=[10,100,1000,10000];
LAMBDA_A=str2num(LA)
LAMBDA_P=str2num(LP)
%ATTENZIONE ALL O M1

if strcmp(type,'HYPERCUBE')
    error_tobe_minimized = @(x) sum(sum((ydata - forecast_5(xdata(1,:),x,47)).^2)) + LAMBDA_A*norm(x(1:types_n),1) + LAMBDA_P*norm(x(types_n+1:types_n^2),1);
else
    error_tobe_minimized = @(x) sum(sum((ydata - forecast_all5(xdata(1,:),x,47)).^2)) + LAMBDA_A*norm(x(1:types_n),1) + LAMBDA_P*norm(x(types_n+1:types_n^2),1);

end
options=optimoptions('particleswarm','SwarmSize',200,'Display','iter','UseParallel',true,'OutputFcns',@save_pswarm);

[x,fval,exitflag,output] = particleswarm(error_tobe_minimized,1024,LowerBounds,UpperBounds,options)
 
load pswarm;
if strcmp(type,'HYPERCUBE')
    up_to_now = forecast_5(xdata(1,:),optimValues.bestx,47);
    last_step = up_to_now(47,:);
    prediction_error = sum(sum((all_ydata(48:end,:) - forecast_5(last_step,optimValues.bestx,PREDICTION_MONTHS)).^2))

else 
    up_to_now = forecast_all5(xdata(1,:),optimValues.bestx,47);
    last_step = up_to_now(47,:);
    prediction_error = sum(sum((all_ydata(48:end,:) - forecast_all5(last_step,optimValues.bestx,PREDICTION_MONTHS)).^2))
end
end


