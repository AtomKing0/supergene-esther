package com.ironsource;

import android.util.Log;
import android.util.Pair;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes4.dex */
public class vb {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15877e = "EventsTracker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private td f15878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private pb f15879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ke f15880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExecutorService f15881d;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f15882a;

        a(String str) {
            this.f15882a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                vo voVar = new vo();
                ArrayList<Pair<String, String>> arrayListD = vb.this.f15879b.d();
                if ("POST".equals(vb.this.f15879b.e())) {
                    voVar = ff.b(vb.this.f15879b.b(), this.f15882a, arrayListD);
                } else if ("GET".equals(vb.this.f15879b.e())) {
                    voVar = ff.a(vb.this.f15879b.b(), this.f15882a, arrayListD);
                }
                vb.this.a("response status code: " + voVar.f15931a);
            } catch (Exception e10) {
                i9.d().a(e10);
            }
        }
    }

    public vb(pb pbVar, td tdVar) {
        if (pbVar == null) {
            throw new InvalidParameterException("Null configuration not supported ");
        }
        if (pbVar.c() == null) {
            throw new InvalidParameterException("Null formatter not supported ");
        }
        this.f15879b = pbVar;
        this.f15878a = tdVar;
        this.f15880c = pbVar.c();
        this.f15881d = Executors.newSingleThreadExecutor();
    }

    private void b(String str) {
        this.f15881d.submit(new a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.f15879b.f()) {
            Log.d(f15877e, str);
        }
    }

    public void a(String str, Map<String, Object> map) {
        a(String.format(Locale.ENGLISH, "%s %s", str, map.toString()));
        if (this.f15879b.a() && !str.isEmpty()) {
            HashMap map2 = new HashMap();
            map2.put("eventname", str);
            a(map2, this.f15878a.a());
            a(map2, map);
            b(this.f15880c.a(map2));
        }
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        try {
            map.putAll(map2);
        } catch (Exception e10) {
            i9.d().a(e10);
        }
    }
}
