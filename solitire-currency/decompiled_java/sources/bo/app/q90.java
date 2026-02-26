package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class q90 {
    /* JADX WARN: Removed duplicated region for block: B:13:0x002a A[Catch: JSONException -> 0x001d, TryCatch #0 {JSONException -> 0x001d, blocks: (B:4:0x0012, B:11:0x0022, B:13:0x002a, B:14:0x0030, B:16:0x0036, B:17:0x0040, B:19:0x0066, B:26:0x0083, B:28:0x0087, B:30:0x0093, B:25:0x0073), top: B:37:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036 A[Catch: JSONException -> 0x001d, TryCatch #0 {JSONException -> 0x001d, blocks: (B:4:0x0012, B:11:0x0022, B:13:0x002a, B:14:0x0030, B:16:0x0036, B:17:0x0040, B:19:0x0066, B:26:0x0083, B:28:0x0087, B:30:0x0093, B:25:0x0073), top: B:37:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066 A[Catch: JSONException -> 0x001d, TryCatch #0 {JSONException -> 0x001d, blocks: (B:4:0x0012, B:11:0x0022, B:13:0x002a, B:14:0x0030, B:16:0x0036, B:17:0x0040, B:19:0x0066, B:26:0x0083, B:28:0x0087, B:30:0x0093, B:25:0x0073), top: B:37:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073 A[Catch: JSONException -> 0x001d, TryCatch #0 {JSONException -> 0x001d, blocks: (B:4:0x0012, B:11:0x0022, B:13:0x002a, B:14:0x0030, B:16:0x0036, B:17:0x0040, B:19:0x0066, B:26:0x0083, B:28:0x0087, B:30:0x0093, B:25:0x0073), top: B:37:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final bo.app.r90 a(org.json.JSONObject r13, boolean r14) {
        /*
            r12 = this;
            java.lang.String r0 = "expiration_time"
            java.lang.String r1 = "authorization_code"
            java.lang.String r2 = "jsonData"
            kotlin.jvm.internal.t.i(r13, r2)
            bo.app.r90 r2 = new bo.app.r90
            r2.<init>()
            r3 = 1
            r4 = 0
            if (r14 != 0) goto L21
            java.lang.String r14 = "enabled"
            boolean r14 = r13.getBoolean(r14)     // Catch: org.json.JSONException -> L1d
            if (r14 == 0) goto L1b
            goto L21
        L1b:
            r14 = r4
            goto L22
        L1d:
            r13 = move-exception
            r3 = r13
            goto La4
        L21:
            r14 = r3
        L22:
            r2.f3752a = r14     // Catch: org.json.JSONException -> L1d
            boolean r14 = r13.has(r1)     // Catch: org.json.JSONException -> L1d
            if (r14 == 0) goto L30
            java.lang.String r14 = r13.getString(r1)     // Catch: org.json.JSONException -> L1d
            r2.f3754c = r14     // Catch: org.json.JSONException -> L1d
        L30:
            boolean r14 = r13.has(r0)     // Catch: org.json.JSONException -> L1d
            if (r14 == 0) goto L40
            long r0 = r13.getLong(r0)     // Catch: org.json.JSONException -> L1d
            java.lang.Long r14 = java.lang.Long.valueOf(r0)     // Catch: org.json.JSONException -> L1d
            r2.f3753b = r14     // Catch: org.json.JSONException -> L1d
        L40:
            java.lang.String r14 = "batching_config"
            org.json.JSONObject r14 = r13.getJSONObject(r14)     // Catch: org.json.JSONException -> L1d
            java.lang.String r0 = "flush_interval_size"
            long r0 = r14.getLong(r0)     // Catch: org.json.JSONException -> L1d
            r2.f3755d = r0     // Catch: org.json.JSONException -> L1d
            java.lang.String r0 = "flush_interval_seconds"
            long r0 = r14.getLong(r0)     // Catch: org.json.JSONException -> L1d
            r2.f3756e = r0     // Catch: org.json.JSONException -> L1d
            java.lang.String r0 = "max_payload_size"
            long r0 = r14.getLong(r0)     // Catch: org.json.JSONException -> L1d
            r2.f3757f = r0     // Catch: org.json.JSONException -> L1d
            long r5 = r2.f3755d     // Catch: org.json.JSONException -> L1d
            r7 = 0
            int r14 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r14 <= 0) goto L73
            long r5 = r2.f3756e     // Catch: org.json.JSONException -> L1d
            int r14 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r14 <= 0) goto L73
            int r14 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r14 > 0) goto L71
            goto L73
        L71:
            r3 = r4
            goto L83
        L73:
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE     // Catch: org.json.JSONException -> L1d
            r6 = 0
            r7 = 0
            r8 = 0
            bo.app.n90 r9 = new bo.app.n90     // Catch: org.json.JSONException -> L1d
            r9.<init>(r13)     // Catch: org.json.JSONException -> L1d
            r10 = 7
            r11 = 0
            r5 = r12
            com.braze.support.BrazeLogger.brazelog$default(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: org.json.JSONException -> L1d
        L83:
            java.lang.Long r13 = r2.f3753b     // Catch: org.json.JSONException -> L1d
            if (r13 == 0) goto La1
            long r13 = r13.longValue()     // Catch: org.json.JSONException -> L1d
            long r0 = com.braze.support.DateTimeUtils.nowInSeconds()     // Catch: org.json.JSONException -> L1d
            int r13 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r13 >= 0) goto La1
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE     // Catch: org.json.JSONException -> L1d
            r6 = 0
            r7 = 0
            r8 = 0
            bo.app.o90 r9 = bo.app.o90.f3550a     // Catch: org.json.JSONException -> L1d
            r10 = 7
            r11 = 0
            r5 = r12
            com.braze.support.BrazeLogger.brazelog$default(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: org.json.JSONException -> L1d
            goto Lb1
        La1:
            if (r3 == 0) goto Lb6
            goto Lb1
        La4:
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.E
            bo.app.p90 r5 = bo.app.p90.f3615a
            r4 = 0
            r6 = 4
            r7 = 0
            r1 = r12
            com.braze.support.BrazeLogger.brazelog$default(r0, r1, r2, r3, r4, r5, r6, r7)
        Lb1:
            bo.app.r90 r2 = new bo.app.r90
            r2.<init>()
        Lb6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.q90.a(org.json.JSONObject, boolean):bo.app.r90");
    }
}
