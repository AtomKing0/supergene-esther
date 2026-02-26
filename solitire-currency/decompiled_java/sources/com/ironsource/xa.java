package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Random;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
public class xa {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16172d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16173e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f16174f = "C38FB23A402222A0C17D34A92F971D1F";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f16175g = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDaUZaiASqhU4+s3JiQaIzVYtC+rZiPX2K+ZRg4C21kBZDNQM5+SEkp5GT5a9W/IR2oz6Q/ucifXcc7QEo5Xl5GX1BAhFI+8KaxPmn5Km5zFdH0aCvrrpDYQpH239Q+2uuUC79G5MpfSIw0zixU4VkF0WbVdHDpgQDds39cPl6cTwIDAQAB";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f16176h = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f16177i = 32;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final xa f16178j = new xa();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16179a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16180b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16181c = "";

    public static xa b() {
        return f16178j;
    }

    public String a() throws JSONException {
        if (TextUtils.isEmpty(this.f16181c)) {
            try {
                this.f16181c = bj.a(d(), f16175g);
            } catch (Exception e10) {
                i9.d().a(e10);
                String str = "Session key encryption exception: " + e10.getLocalizedMessage();
                IronLog.INTERNAL.error(str);
                throw new JSONException(str);
            }
        }
        return this.f16181c;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f16179a)) {
            this.f16179a = f16174f;
        }
        return this.f16179a;
    }

    public synchronized String d() {
        if (TextUtils.isEmpty(this.f16180b)) {
            this.f16180b = a(f16176h, 32);
        }
        return this.f16180b;
    }

    private String a(String str, int i10) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i11 = 0; i11 < i10; i11++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        return sb.toString();
    }
}
