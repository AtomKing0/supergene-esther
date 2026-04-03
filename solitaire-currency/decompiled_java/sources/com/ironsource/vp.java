package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* JADX INFO: loaded from: classes4.dex */
public class vp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f15933a = new a(2001, a("initsdk"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f15934b = new a(2026, a("sdkrecoverstart"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f15935c = new a(2002, a("createcontrollerweb"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f15936d = new a(2003, a("createcontrollernative"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f15937e = new a(2004, a("controllerstageready"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f15938f = new a(2005, a("loadad"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static a f15939g = new a(2006, a("loadadfailed"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a f15940h = new a(2007, a("initproduct"));

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static a f15941i = new a(2008, a("initproductfailed"));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static a f15942j = new a(2009, a("loadproduct"));

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static a f15943k = new a(IronSourceError.ERROR_OLD_INIT_API_APP_KEY_IS_NULL, a("parseadmfailed"));

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static a f15944l = new a(2011, a("loadadsuccess"));

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static a f15945m = new a(2027, a("destroyproduct"));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static a f15946n = new a(IronSourceError.ERROR_OLD_API_INIT_IN_PROGRESS, a("registerad"));

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static a f15947o = new a(2013, a("controllerfailed"));

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static a f15948p = new a(2015, a("appendnativefeaturesdatafailed"));

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static a f15949q = new a(2016, a("adunitcouldnotloadtowebview"));

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static a f15950r = new a(2017, a("webviewcleanupfailed"));

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static a f15951s = new a(2018, a("removewebviewfailed"));

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static a f15952t = new a(2020, a("banneralreadydestroyed"));

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static a f15953u = new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_SUCCESS, a("fialedregactlifecycle"));

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static a f15954v = new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_FAILED, a("loadcontrollerhtml"));

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static a f15955w = new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_TIMED_OUT, a("controllerhtmlsuccess"));

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static a f15956x = new a(2024, a("controllerhtmlfailed"));

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static a f15957y = new a(2025, a("webviewcrashrpg"));

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static a f15958z = new a(2031, a("getorientationcalled"));
    public static a A = new a(2032, a("webviewunavailable"));
    public static final a B = new a(2033, a("controller_init_delayed"));

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f15960b;

        a(int i10, String str) {
            this.f15960b = i10;
            this.f15959a = str;
        }
    }

    static String a(String str) {
        return nb.f14105c + str;
    }
}
