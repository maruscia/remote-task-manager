function stop = pswarmed(optimValues,state)
% Output function that plots the iterates of the optimization algorithm.
warning off 'parallel:cluster:CannotSaveCorrectly'
 global all_ydata
 global xdata
 global ydata
 global PREDICTION_MONTHS
 global best_pe
 global type
 global LAMBDA_A
 global LAMBDA_P
stop = false;
%assignin('base','optimValues',optimValues);
%x = optimValues.bestx;
if strcmp(type,'HYPERCUBE')
    up_to_now = forecast_5(xdata(1,:),optimValues.bestx,47);
    last_step = up_to_now(47,:);
    prediction_error = sum(sum((all_ydata(48:end,:) - forecast_5(last_step,optimValues.bestx,PREDICTION_MONTHS)).^2));
else
    up_to_now = forecast_all5(xdata(1,:),optimValues.bestx,47);
    last_step = up_to_now(47,:);
    prediction_error = sum(sum((all_ydata(48:end,:) - forecast_all5(last_step,optimValues.bestx,PREDICTION_MONTHS)).^2));
end

if prediction_error < best_pe
    best_pe = prediction_error;
    fprintf('>> Best prediction error updated: %e\n',best_pe)
    Best = struct();
    Best.x = optimValues.bestx;
    Best.type=type;
    Best.pe = best_pe;
    Best.fval = optimValues.bestfval;
    Best.iteration = optimValues.iteration;
    filename =sprintf('best%2f_%2f.mat',LAMBDA_A,LAMBDA_P);
    save(filename,'Best');
end

MAX_A = max(optimValues.bestx(1:32));
delete('./MaxA_*');
SUM_P =sum(optimValues.bestx(33:1024));
delete('./SumP_*');
maxa = sprintf('MaxA_%2f',MAX_A);
sump = sprintf('SumP_%2f',SUM_P);
save(maxa,'MAX_A');
save(sump,'SUM_P');
optimValues.pe = prediction_error;
filename =sprintf('pswarm%2f_%2f.mat',LAMBDA_A,LAMBDA_P);
save(filename,'optimValues');
 %figure(1);
 %bar(optimValues.bestx(1:32));
 %drawnow
 
 %figure(2);
 %bar(optimValues.bestx(33:1024));
 %drawnow
            
end