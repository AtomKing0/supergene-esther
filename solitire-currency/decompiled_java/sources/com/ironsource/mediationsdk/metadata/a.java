package com.ironsource.mediationsdk.metadata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13682a = "do_not_sell";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13683b = "is_child_directed";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13684c = "is_deviceid_optout";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13685d = "google_family_self_certified_sdks";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13686e = "iiqf";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13687f = "is_test_suite";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13688g = "true";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected static final String f13689h = "false";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f13690i = "google_water_mark";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f13691j = "enable";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final Set<String> f13692k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final Set<String> f13693l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final Set<String> f13694m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f13695n = 2048;

    static {
        HashSet hashSet = new HashSet(Arrays.asList(f13683b, f13684c, f13687f, f13685d, f13686e));
        f13692k = hashSet;
        f13693l = new HashSet(Arrays.asList(f13684c, f13685d, f13687f, f13686e));
        HashSet hashSet2 = new HashSet(hashSet);
        f13694m = hashSet2;
        hashSet2.add(f13682a);
    }
}
