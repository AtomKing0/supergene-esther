package com.onetrust.otpublishers.headless.Public.OTUIDisplayReason;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public class OTUIDisplayReason {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22024c;

    public OTUIDisplayReason(int i10, @NonNull String str) {
        this.f22023b = i10;
        this.f22024c = str;
        this.f22022a = i10 + " - " + str;
    }

    public int getResponseCode() {
        return this.f22023b;
    }

    @NonNull
    public String getResponseMessage() {
        return this.f22024c;
    }

    @NonNull
    public String logReason() {
        return this.f22022a;
    }

    @NonNull
    public String toString() {
        return "OTUIDisplayReason{logMessage='" + this.f22022a + "', responseCode=" + this.f22023b + ", responseMessage='" + this.f22024c + "'}";
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @androidx.annotation.NonNull
    public static java.lang.String getResponseMessage(int r1) {
        /*
            java.lang.String r0 = "Displaying OT Banner because new category or purpose addition is detected."
            switch(r1) {
                case 101: goto L27;
                case 102: goto L24;
                case 103: goto L21;
                case 104: goto L1e;
                case 105: goto L1b;
                case 106: goto L18;
                case 107: goto L15;
                case 108: goto L12;
                case 109: goto Lf;
                case 110: goto Lc;
                case 111: goto Lb;
                default: goto L5;
            }
        L5:
            switch(r1) {
                case 201: goto L46;
                case 202: goto L43;
                case 203: goto L40;
                case 204: goto L3d;
                case 205: goto L3a;
                case 206: goto L37;
                case 207: goto L34;
                case 208: goto L31;
                case 209: goto L2e;
                case 210: goto L2b;
                case 211: goto L2a;
                default: goto L8;
            }
        L8:
            java.lang.String r1 = "Banner / PC shown, not defined reason code."
            return r1
        Lb:
            return r0
        Lc:
            java.lang.String r1 = "Displaying OT Banner because the application has called the the API to show OT SDK UI."
            return r1
        Lf:
            java.lang.String r1 = "Displaying OT Banner because sdk has moved from one region to another."
            return r1
        L12:
            java.lang.String r1 = "Displaying OT Banner because sdk has entered backward compatibility mode and OT SDK UI has never been shown until now."
            return r1
        L15:
            java.lang.String r1 = "Displaying OT Banner because hundred percent sync has not happened for cross device sync enabled scenario."
            return r1
        L18:
            java.lang.String r1 = "Displaying OT Banner because service specific is off as part of TC string details."
            return r1
        L1b:
            java.lang.String r1 = "Displaying OT Banner because consent has expired."
            return r1
        L1e:
            java.lang.String r1 = "Displaying OT Banner because the TC String has expired."
            return r1
        L21:
            java.lang.String r1 = "Displaying OT Banner because sdk's reconsent has expired."
            return r1
        L24:
            java.lang.String r1 = "Displaying OT Banner because sdk has been published with reconsent."
            return r1
        L27:
            java.lang.String r1 = "Displaying OT Banner because georule has it enabled."
            return r1
        L2a:
            return r0
        L2b:
            java.lang.String r1 = "Displaying OT Preference Center because the application has called the the API to show OT SDK UI."
            return r1
        L2e:
            java.lang.String r1 = "Displaying OT Preference Center because sdk has moved from one region to another."
            return r1
        L31:
            java.lang.String r1 = "Displaying OT Preference Center because sdk has entered backward compatibility mode and OT SDK UI has never been shown until now."
            return r1
        L34:
            java.lang.String r1 = "Displaying OT Preference Center because hundred percent sync has not happened for cross device sync enabled scenario."
            return r1
        L37:
            java.lang.String r1 = "Displaying OT Preference Center because service specific is off as part of TC string details."
            return r1
        L3a:
            java.lang.String r1 = "Displaying OT Preference Center because consent has expired."
            return r1
        L3d:
            java.lang.String r1 = "Displaying OT Preference Center because the TC String has expired."
            return r1
        L40:
            java.lang.String r1 = "Displaying OT Preference Center because sdk's reconsent has expired."
            return r1
        L43:
            java.lang.String r1 = "Displaying OT Preference Center because sdk has been published with reconsent."
            return r1
        L46:
            java.lang.String r1 = "Displaying OT Preference Center because georule has it enabled."
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason.getResponseMessage(int):java.lang.String");
    }
}
