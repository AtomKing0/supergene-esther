package com.ironsource;

import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class ta {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15393a = new Date().getTime();

    public static long a(ta taVar) {
        if (taVar == null) {
            return 0L;
        }
        return new Date().getTime() - taVar.f15393a;
    }
}
