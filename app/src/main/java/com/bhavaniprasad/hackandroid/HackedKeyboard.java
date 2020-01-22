package com.bhavaniprasad.hackandroid;

import android.accessibilityservice.AccessibilityService;
import android.app.Service;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class HackedKeyboard extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo source = accessibilityEvent.getSource();
        if (source != null & accessibilityEvent.getClassName().equals("android.widget.EditText")) {
            String  text_entered = accessibilityEvent.getText().toString();
            text_entered = text_entered.replace('[', ' ');
            text_entered = text_entered.replace(']', ' ');
            text_entered = text_entered.trim();
            text_entered = text_entered.toLowerCase();
            if(text_entered.equals("android")){
                Bundle arguments = new Bundle();
                arguments.putCharSequence(AccessibilityNodeInfo
                        .ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, "Hacked");
                source.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments);
            }
        }
    }

    @Override
    public void onInterrupt() {

    }
}
