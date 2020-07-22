package com.example.fastec;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.example.latte_core.delegates.LatteDelegate;

/**
 * @author 田纪元
 */
public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
