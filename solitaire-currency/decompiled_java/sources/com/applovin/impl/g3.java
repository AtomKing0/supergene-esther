package com.applovin.impl;

import com.applovin.impl.p4;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g3 extends l4 {
    public static final l4 A6;
    public static final l4 A7;
    public static final l4 B6;
    public static final l4 B7;
    public static final l4 C6;
    public static final l4 C7;
    public static final l4 D6;
    public static final l4 D7;
    public static final l4 E6;
    public static final l4 E7;
    public static final l4 F6;
    public static final l4 G6;
    public static final l4 H6;
    public static final l4 I6;
    public static final l4 J6;
    public static final l4 K6;
    public static final l4 L6;
    public static final l4 M6;
    public static final l4 N6;
    public static final l4 O6;
    public static final l4 P6;
    public static final l4 Q6;
    public static final l4 R6;
    public static final l4 S6;
    public static final l4 T6;
    public static final l4 U6;
    public static final l4 V6;
    public static final l4 W6;
    public static final l4 X6;
    public static final l4 Y6;
    public static final l4 Z6;

    /* JADX INFO: renamed from: a7, reason: collision with root package name */
    public static final l4 f5225a7;

    /* JADX INFO: renamed from: b7, reason: collision with root package name */
    public static final l4 f5226b7;

    /* JADX INFO: renamed from: c7, reason: collision with root package name */
    public static final l4 f5227c7;

    /* JADX INFO: renamed from: d7, reason: collision with root package name */
    public static final l4 f5228d7;

    /* JADX INFO: renamed from: e7, reason: collision with root package name */
    public static final l4 f5229e7;

    /* JADX INFO: renamed from: f7, reason: collision with root package name */
    public static final l4 f5230f7;

    /* JADX INFO: renamed from: g7, reason: collision with root package name */
    public static final l4 f5231g7;

    /* JADX INFO: renamed from: h7, reason: collision with root package name */
    public static final l4 f5232h7;

    /* JADX INFO: renamed from: i7, reason: collision with root package name */
    public static final l4 f5233i7;

    /* JADX INFO: renamed from: j7, reason: collision with root package name */
    public static final l4 f5234j7;

    /* JADX INFO: renamed from: k7, reason: collision with root package name */
    public static final l4 f5235k7;

    /* JADX INFO: renamed from: l7, reason: collision with root package name */
    public static final l4 f5236l7;

    /* JADX INFO: renamed from: m7, reason: collision with root package name */
    public static final l4 f5237m7;

    /* JADX INFO: renamed from: n7, reason: collision with root package name */
    public static final l4 f5238n7;

    /* JADX INFO: renamed from: o7, reason: collision with root package name */
    public static final l4 f5239o7;

    /* JADX INFO: renamed from: p7, reason: collision with root package name */
    public static final l4 f5240p7;

    /* JADX INFO: renamed from: q7, reason: collision with root package name */
    public static final l4 f5241q7;

    /* JADX INFO: renamed from: r7, reason: collision with root package name */
    public static final l4 f5242r7;

    /* JADX INFO: renamed from: s7, reason: collision with root package name */
    public static final l4 f5243s7;

    /* JADX INFO: renamed from: t7, reason: collision with root package name */
    public static final l4 f5244t7;

    /* JADX INFO: renamed from: u6, reason: collision with root package name */
    public static final l4 f5245u6 = l4.a("afi", "");

    /* JADX INFO: renamed from: u7, reason: collision with root package name */
    public static final l4 f5246u7;

    /* JADX INFO: renamed from: v6, reason: collision with root package name */
    public static final l4 f5247v6;

    /* JADX INFO: renamed from: v7, reason: collision with root package name */
    public static final l4 f5248v7;

    /* JADX INFO: renamed from: w6, reason: collision with root package name */
    public static final l4 f5249w6;

    /* JADX INFO: renamed from: w7, reason: collision with root package name */
    public static final l4 f5250w7;

    /* JADX INFO: renamed from: x6, reason: collision with root package name */
    public static final l4 f5251x6;

    /* JADX INFO: renamed from: x7, reason: collision with root package name */
    public static final l4 f5252x7;

    /* JADX INFO: renamed from: y6, reason: collision with root package name */
    public static final l4 f5253y6;

    /* JADX INFO: renamed from: y7, reason: collision with root package name */
    public static final l4 f5254y7;

    /* JADX INFO: renamed from: z6, reason: collision with root package name */
    public static final l4 f5255z6;

    /* JADX INFO: renamed from: z7, reason: collision with root package name */
    public static final l4 f5256z7;

    static {
        Boolean bool = Boolean.FALSE;
        f5247v6 = l4.a("iafiwaa", bool);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f5249w6 = l4.a("afi_ms", Long.valueOf(timeUnit.toMillis(5L)));
        f5251x6 = l4.a("mediation_endpoint", "https://ms.applovin.com/");
        f5253y6 = l4.a("mediation_backup_endpoint", "https://ms.applvn.com/");
        f5255z6 = l4.a("fetch_next_ad_retry_delay_ms", Long.valueOf(timeUnit.toMillis(2L)));
        A6 = l4.a("fetch_next_ad_timeout_ms", Long.valueOf(timeUnit.toMillis(30L)));
        B6 = l4.a("fetch_mediation_debugger_info_timeout_ms", Long.valueOf(timeUnit.toMillis(7L)));
        Boolean bool2 = Boolean.TRUE;
        C6 = l4.a("auto_init_mediation_debugger", bool2);
        D6 = l4.a("postback_macros", "{\"{MCODE}\":\"mcode\",\"{BCODE}\":\"bcode\",\"{ICODE}\":\"icode\",\"{SCODE}\":\"scode\"}");
        E6 = l4.a("max_signal_provider_latency_ms", Long.valueOf(timeUnit.toMillis(30L)));
        F6 = l4.a("default_adapter_timeout_ms", Long.valueOf(timeUnit.toMillis(10L)));
        G6 = l4.a("ad_refresh_ms", Long.valueOf(timeUnit.toMillis(30L)));
        H6 = l4.a("ad_load_failure_refresh_ms", Long.valueOf(timeUnit.toMillis(30L)));
        I6 = l4.a("ad_load_failure_refresh_ignore_error_codes", "204");
        J6 = l4.a("refresh_ad_on_app_resume_elapsed_threshold_ms", 0L);
        K6 = l4.a("refresh_ad_view_timer_responds_to_background", bool2);
        L6 = l4.a("refresh_ad_view_timer_responds_to_store_kit", bool2);
        M6 = l4.a("refresh_ad_view_timer_responds_to_window_visibility_changed", bool);
        N6 = l4.a("avrsponse", bool);
        O6 = l4.a("allow_pause_auto_refresh_immediately", bool);
        P6 = l4.a("ad_view_race_condition_fix_enabled", bool);
        Q6 = l4.a("always_destroy_ad_view_on_ui_thread", bool);
        R6 = l4.a("fullscreen_display_delay_ms", 0L);
        S6 = l4.a("susaode", bool);
        T6 = l4.a("ahdm", 500L);
        U6 = l4.a("ad_view_refresh_precache_request_viewability_undesired_flags", 246L);
        V6 = l4.a("ad_view_refresh_precache_request_enabled", bool2);
        W6 = l4.a("famttl_ms", 0L);
        X6 = l4.a("signal_expiration_ms", -1L);
        Y6 = l4.a("signal_cache_level", Integer.valueOf(p4.b.AD_FORMAT.ordinal()));
        TimeUnit timeUnit2 = TimeUnit.HOURS;
        Z6 = l4.a("ad_expiration_ms", Long.valueOf(timeUnit2.toMillis(4L)));
        f5225a7 = l4.a("native_ad_expiration_ms", Long.valueOf(timeUnit2.toMillis(4L)));
        f5226b7 = l4.a("rena", bool2);
        f5227c7 = l4.a("fullscreen_ad_displayed_timeout_ms", -1L);
        f5228d7 = l4.a("freast_ms", -1L);
        f5229e7 = l4.a("ad_hidden_timeout_ms", -1L);
        f5230f7 = l4.a("schedule_ad_hidden_on_ad_dismiss", bool);
        f5231g7 = l4.a("schedule_ad_hidden_on_single_task_app_relaunch", bool);
        f5232h7 = l4.a("ad_hidden_on_ad_dismiss_callback_delay_ms", Long.valueOf(timeUnit.toMillis(1L)));
        f5233i7 = l4.a("proe", bool);
        f5234j7 = l4.a("teatfmacc", bool);
        f5235k7 = l4.a("mute_state", 2);
        f5236l7 = l4.a("saf", "");
        f5237m7 = l4.a("saui", "");
        f5238n7 = l4.a("mra", -1);
        f5239o7 = l4.a("mra_af", "INTER,REWARDED,BANNER,LEADER,MREC");
        f5240p7 = l4.a("fadiafase", bool2);
        f5241q7 = l4.a("fadwvcv", bool2);
        f5242r7 = l4.a("bfarud", bool);
        f5243s7 = l4.a("inacc", Boolean.valueOf(z6.b(Arrays.asList("com.textmeinc.textme", "com.textmeinc.freetone", "com.textmeinc.textme3", "com.jaumo", "com.jaumo.casual", "com.pinkapp", "com.jaumo.mature", "com.jaumo.prime", "com.jaumo.gay", "com.jaumo.lesbian"))));
        f5244t7 = l4.a("adiets_sec", Long.valueOf(TimeUnit.MINUTES.toSeconds(1L)));
        f5246u7 = l4.a("faomq", bool);
        f5248v7 = l4.a("rahcnct_sec", -1);
        f5250w7 = l4.a("uabta", bool);
        f5252x7 = l4.a("use_initialization_spec_during_init", bool);
        f5254y7 = l4.a("report_cimp_after_ierr", bool);
        f5256z7 = l4.a("fail_collection_for_empty_signal", bool);
        A7 = l4.a("fetch_mediated_ad_gzip", bool2);
        B7 = l4.a("max_postback_gzip", bool2);
        C7 = l4.a("md_endpoint", "https://md.applovin.com/");
        D7 = l4.a("md_backup_endpoint", "https://md.applvn.com/");
        E7 = l4.a("md_v2", bool);
    }
}
