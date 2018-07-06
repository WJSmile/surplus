package com.surplus.mvp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    public P  mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.onDestroy();
            mPresenter = null;
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }


    /**
     * 切换Fragment
     */
    private Fragment currentFragment = new Fragment();
    @SuppressLint("CommitTransaction")
    private void switchFragment(Fragment targetFragment,int layoutId){
         FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
         if (!targetFragment.isAdded()){
             if (currentFragment!=null){
                 transaction.hide(currentFragment);
             }
             transaction.add(layoutId,targetFragment,targetFragment.getClass().getName());
         }else {
             transaction.hide(currentFragment).show(targetFragment);
         }
        currentFragment = targetFragment;
    }

}
