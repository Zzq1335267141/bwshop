package com.bw.zzq0513week1.presenter;

import com.bw.zzq0513week1.model.Model;
import com.bw.zzq0513week1.model.ModelImpl;
import com.bw.zzq0513week1.view.IView;

/**
 * Created by Android Studio.
 * User: 张泽强
 * Date: 2019/5/13
 * Time: 9:22
 */
public class PresenterImpl implements Presenter {


    private IView iView;
    private Model model;

    public PresenterImpl(IView iView) {
        model = new ModelImpl();
        this.iView = iView;
    }

    //交互
    @Override
    public void onTach(IView iView) {
        this.iView = iView;
    }

    @Override
    public void startResult(String uri) {
        model.getRequestData(uri, new Model.CallBack() {
            @Override
            public void setRequestData(String info) {
                iView.setResponse(info);
            }
        });
    }

    @Override
    public void deTach() {
        if(model!=null){
            model=null;
        }
        if(iView!=null){
            iView=null;
        }
    }
}
