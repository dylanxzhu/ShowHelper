package com.yuewawa.showhelper.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yuewawa.showhelper.R;
import com.yuewawa.showhelper.biz.IUserBiz;
import com.yuewawa.showhelper.biz.impl.UserBiz;
import com.yuewawa.showhelper.entity.User;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * Created by yuewawa on 2016-10-07.
 */
@EActivity(R.layout.login)
public class LoginActivity extends Activity {

    @ViewById(R.id.userName_edt)
    protected EditText userNameEdt;
    @ViewById(R.id.userPassword_edt)
    protected EditText userPasswordEdt;
    @ViewById(R.id.login_btn)
    protected Button loginBtn;
    @ViewById(R.id.toRegister_txt)
    protected TextView toRegisterTxt;

    private IUserBiz userBiz;
    private User user;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Click(R.id.login_btn)
    protected void login() {
        String userName = userNameEdt.getText().toString();
        String userPassword = userPasswordEdt.getText().toString();
        if (userName == null || userName.equals("")
                || userPassword == null || userPassword.equals("")) {
            Toast.makeText(LoginActivity.this, "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        userBiz = new UserBiz(LoginActivity.this);
        List<User> users = userBiz.userLogin(userName, userPassword);
        if (users != null && users.size() > 0) {
            intent = new Intent(LoginActivity.this, MainActivity_.class);
            intent.putExtra("userName", userName);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
        }
    }
}
