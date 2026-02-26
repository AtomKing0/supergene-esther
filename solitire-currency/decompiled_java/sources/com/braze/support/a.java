package com.braze.support;

import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f8112a;

    static {
        int[] iArr = new int[BrazeLogger.Priority.values().length];
        try {
            iArr[BrazeLogger.Priority.D.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[BrazeLogger.Priority.I.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[BrazeLogger.Priority.E.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[BrazeLogger.Priority.W.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[BrazeLogger.Priority.V.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        f8112a = iArr;
    }
}
