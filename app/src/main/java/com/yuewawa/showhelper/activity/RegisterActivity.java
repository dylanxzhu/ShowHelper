package com.yuewawa.showhelper.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yuewawa.showhelper.R;
import com.yuewawa.showhelper.biz.IUserBiz;
import com.yuewawa.showhelper.biz.impl.UserBiz;
import com.yuewawa.showhelper.entity.User;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by yuewawa on 2016-10-07.
 */
@EActivity(R.layout.register)
public class RegisterActivity extends Activity {

    @ViewById(R.id.userName_edt)
    protected EditText userNameEdt;
    @ViewById(R.id.userPassword_edt)
    protected EditText userPasswordEdt;
    @ViewById(R.id.register_btn)
    protected Button registerBtn;

    private IUserBiz userBiz;
    private User user;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Click(R.id.register_btn)
    protected void register() {
        String userName = userNameEdt.getText().toString();
        String userPassword = userPasswordEdt.getText().toString();
        if (userName == null || userName.equals("")
                || userPassword == null || userPassword.equals("")) {
            Toast.makeText(RegisterActivity.this, "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        userBiz = new UserBiz(RegisterActivity.this);
        user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        long result = userBiz.userRegister(user);
        if (result == 0) {
            Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            intent = new Intent(RegisterActivity.this, LoginActivity_.class);
            startActivity(intent);
            finish();
        }
    }
}
