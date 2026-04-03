package com.ironsource.mediationsdk.integration;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.sdk.AppLovinMediationProvider;
import com.ironsource.environment.StringUtils;
import com.ironsource.i9;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import io.sentry.SentryOptions;

/* JADX INFO: loaded from: classes4.dex */
public class IntegrationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f13627a = "IntegrationHelper";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f13628b = "4.1";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f13629c = "4.3";

    class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f13630a;

        a(Context context) {
            this.f13630a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Log.w(IntegrationHelper.f13627a, "--------------- Google Play Services --------------");
                if (this.f13630a.getPackageManager().getApplicationInfo(this.f13630a.getPackageName(), 128).metaData.containsKey("com.google.android.gms.version")) {
                    Log.i(IntegrationHelper.f13627a, "Google Play Services - VERIFIED");
                    String strB = p.m().b(this.f13630a);
                    if (!TextUtils.isEmpty(strB)) {
                        Log.i(IntegrationHelper.f13627a, "GAID is: " + strB + " (use this for test devices)");
                    }
                } else {
                    Log.e(IntegrationHelper.f13627a, "Google Play Services - MISSING");
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                Log.e(IntegrationHelper.f13627a, "Google Play Services - MISSING");
            }
        }
    }

    private static IntegrationData a(Context context, String str) {
        String str2;
        try {
            IntegrationData integrationData = (IntegrationData) Class.forName(str).getMethod("getIntegrationData", Context.class).invoke(null, context);
            Log.i(f13627a, "Adapter " + integrationData.version + " - VERIFIED");
            return integrationData;
        } catch (ClassNotFoundException e10) {
            i9.d().a(e10);
            str2 = "Adapter - MISSING";
            Log.e(f13627a, str2);
            return null;
        } catch (Exception e11) {
            i9.d().a(e11);
            str2 = "Adapter version - NOT VERIFIED";
            Log.e(f13627a, str2);
            return null;
        }
    }

    private static void b(Context context) {
        Log.i(f13627a, "*** Permissions ***");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager.checkPermission("android.permission.INTERNET", context.getPackageName()) == 0) {
            Log.i(f13627a, "android.permission.INTERNET - VERIFIED");
        } else {
            Log.e(f13627a, "android.permission.INTERNET - MISSING");
        }
        if (packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0) {
            Log.i(f13627a, "android.permission.ACCESS_NETWORK_STATE - VERIFIED");
        } else {
            Log.e(f13627a, "android.permission.ACCESS_NETWORK_STATE - MISSING");
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void validateIntegration(Context context) {
        String str;
        Log.i(f13627a, "Verifying Integration:");
        b(context);
        String[] strArr = {"AppLovin", "APS", "BidMachine", "Bigo", "Chartboost", "Fyber", "AdMob", "HyprMX", "InMobi", "IronSource", "Vungle", "Maio", "Facebook", "Mintegral", "MobileFuse", "Moloco", "MyTarget", "Ogury", "Pangle", "Smaato", "SuperAwesome", "UnityAds", "Verve", "Yandex"};
        for (int i10 = 0; i10 < 24; i10++) {
            String str2 = strArr[i10];
            if (!b(context, str2)) {
                String lowerCase = StringUtils.toLowerCase(str2);
                lowerCase.hashCode();
                switch (lowerCase) {
                    case "vungle":
                        str = ">>>> Liftoff Monetization - NOT VERIFIED";
                        break;
                    case "admob":
                        str = ">>>> Google (AdMob and Ad Manager) - NOT VERIFIED";
                        break;
                    case "facebook":
                        str = ">>>> Meta - NOT VERIFIED";
                        break;
                    default:
                        Log.e(f13627a, ">>>> " + str2 + " - NOT VERIFIED");
                        continue;
                        break;
                }
            } else {
                String lowerCase2 = StringUtils.toLowerCase(str2);
                lowerCase2.hashCode();
                switch (lowerCase2.hashCode()) {
                    case -805296079:
                        if (lowerCase2.equals("vungle")) {
                        }
                        break;
                    case 92668925:
                        if (lowerCase2.equals(AppLovinMediationProvider.ADMOB)) {
                        }
                        break;
                    case 497130182:
                        if (!lowerCase2.equals("facebook")) {
                        }
                        break;
                    default:
                        break;
                }
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Switch insn not found in header
                    	at java.base/java.util.Objects.requireNonNull(Objects.java:259)
                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:195)
                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    */
                /*
                    Method dump skipped, instruction units count: 298
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.integration.IntegrationHelper.validateIntegration(android.content.Context):void");
            }

            private static void a(Context context) {
                new a(context).start();
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private static boolean b(android.content.Context r7, java.lang.String r8) {
                /*
                    java.lang.String r0 = "IntegrationHelper"
                    r1 = 0
                    java.lang.String r2 = com.ironsource.environment.StringUtils.toLowerCase(r8)     // Catch: java.lang.Exception -> La0
                    int r3 = r2.hashCode()     // Catch: java.lang.Exception -> La0
                    r4 = -805296079(0xffffffffd0002831, float:-8.600471E9)
                    r5 = 2
                    r6 = 1
                    if (r3 == r4) goto L31
                    r4 = 92668925(0x58603fd, float:1.2602765E-35)
                    if (r3 == r4) goto L27
                    r4 = 497130182(0x1da19ac6, float:4.2776377E-21)
                    if (r3 == r4) goto L1d
                    goto L3b
                L1d:
                    java.lang.String r3 = "facebook"
                    boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> La0
                    if (r2 == 0) goto L3b
                    r2 = r1
                    goto L3c
                L27:
                    java.lang.String r3 = "admob"
                    boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> La0
                    if (r2 == 0) goto L3b
                    r2 = r6
                    goto L3c
                L31:
                    java.lang.String r3 = "vungle"
                    boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> La0
                    if (r2 == 0) goto L3b
                    r2 = r5
                    goto L3c
                L3b:
                    r2 = -1
                L3c:
                    if (r2 == 0) goto L5f
                    if (r2 == r6) goto L5c
                    if (r2 == r5) goto L59
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La0
                    r2.<init>()     // Catch: java.lang.Exception -> La0
                    java.lang.String r3 = "--------------- "
                    r2.append(r3)     // Catch: java.lang.Exception -> La0
                    r2.append(r8)     // Catch: java.lang.Exception -> La0
                    java.lang.String r3 = " --------------"
                    r2.append(r3)     // Catch: java.lang.Exception -> La0
                    java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> La0
                    goto L61
                L59:
                    java.lang.String r2 = "--------------- Liftoff Monetization --------------"
                    goto L61
                L5c:
                    java.lang.String r2 = "--------------- Google (AdMob and Ad Manager) --------------"
                    goto L61
                L5f:
                    java.lang.String r2 = "--------------- Meta --------------"
                L61:
                    android.util.Log.i(r0, r2)     // Catch: java.lang.Exception -> La0
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La0
                    r2.<init>()     // Catch: java.lang.Exception -> La0
                    java.lang.String r3 = "com.ironsource.adapters."
                    r2.append(r3)     // Catch: java.lang.Exception -> La0
                    java.lang.String r3 = com.ironsource.environment.StringUtils.toLowerCase(r8)     // Catch: java.lang.Exception -> La0
                    r2.append(r3)     // Catch: java.lang.Exception -> La0
                    java.lang.String r3 = "."
                    r2.append(r3)     // Catch: java.lang.Exception -> La0
                    r2.append(r8)     // Catch: java.lang.Exception -> La0
                    java.lang.String r3 = "Adapter"
                    r2.append(r3)     // Catch: java.lang.Exception -> La0
                    java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> La0
                    com.ironsource.mediationsdk.IntegrationData r7 = a(r7, r2)     // Catch: java.lang.Exception -> La0
                    if (r7 != 0) goto L8d
                    return r1
                L8d:
                    java.lang.String r3 = "IronSource"
                    boolean r3 = r8.equalsIgnoreCase(r3)     // Catch: java.lang.Exception -> La0
                    if (r3 != 0) goto L9c
                    boolean r7 = a(r7)     // Catch: java.lang.Exception -> La0
                    if (r7 != 0) goto L9c
                    return r1
                L9c:
                    a(r2)     // Catch: java.lang.Exception -> La0
                    return r6
                La0:
                    r7 = move-exception
                    com.ironsource.i9 r2 = com.ironsource.i9.d()
                    r2.a(r7)
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "isAdapterValid "
                    r2.append(r3)
                    r2.append(r8)
                    java.lang.String r8 = r2.toString()
                    android.util.Log.e(r0, r8, r7)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.integration.IntegrationHelper.b(android.content.Context, java.lang.String):boolean");
            }

            private static void a(String str) {
                try {
                    Log.i(f13627a, "SDK Version - " + ((String) Class.forName(str).getMethod("getAdapterSDKVersion", new Class[0]).invoke(null, new Object[0])));
                } catch (Exception e10) {
                    i9.d().a(e10);
                    Log.w("validateSDKVersion", "Unable to get SDK version");
                }
            }

            private static boolean a(IntegrationData integrationData) {
                if (integrationData.version.startsWith(f13628b) || integrationData.version.startsWith(f13629c)) {
                    Log.i(f13627a, "Adapter - VERIFIED");
                    return true;
                }
                Log.e(f13627a, integrationData.name + " adapter " + integrationData.version + " is incompatible with SDK version " + IronSourceUtils.getSDKVersion() + ", please update your adapter to version " + f13628b + SentryOptions.DEFAULT_PROPAGATION_TARGETS);
                return false;
            }
        }
