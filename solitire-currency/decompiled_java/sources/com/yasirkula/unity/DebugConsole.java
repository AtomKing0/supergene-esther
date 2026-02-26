package com.yasirkula.unity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class DebugConsole {
    public static void CopyText(Context context, String str) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("log", str));
    }
}
