package com.google.firebase.messaging;

import java.util.Locale;

/* JADX INFO: compiled from: SendException.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v0 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10478a;

    v0(String str) {
        super(str);
        this.f10478a = a(str);
    }

    private int a(String str) {
        if (str == null) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.hashCode();
        switch (lowerCase) {
        }
        return 0;
    }
}
