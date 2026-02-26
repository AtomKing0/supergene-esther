package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IronSource.AD_UNIT f16103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f16104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private w1 f16105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final m7 f16106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ug f16107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public sk f16108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public pt f16109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k4 f16110i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j0 f16111j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ut f16112k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Map<u1, a> f16113l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Map<u1, a> f16114m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Map<u1, a> f16115n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Map<u1, a> f16116o;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f16117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f16118b;

        public a(int i10, int i11) {
            this.f16117a = i10;
            this.f16118b = i11;
        }

        int a(b bVar) {
            return b.MEDIATION.equals(bVar) ? this.f16117a : this.f16118b;
        }
    }

    public enum b {
        MEDIATION,
        PROVIDER
    }

    public x1(IronSource.AD_UNIT ad_unit, b bVar, w1 w1Var) {
        this(ad_unit, bVar, w1Var, a(ad_unit));
    }

    private int a(u1 u1Var) {
        try {
            if (IronSource.AD_UNIT.INTERSTITIAL.equals(this.f16103b) && this.f16113l.containsKey(u1Var)) {
                return this.f16113l.get(u1Var).a(this.f16104c);
            }
            if (IronSource.AD_UNIT.REWARDED_VIDEO.equals(this.f16103b) && this.f16114m.containsKey(u1Var)) {
                return this.f16114m.get(u1Var).a(this.f16104c);
            }
            if (IronSource.AD_UNIT.BANNER.equals(this.f16103b) && this.f16115n.containsKey(u1Var)) {
                return this.f16115n.get(u1Var).a(this.f16104c);
            }
            if (IronSource.AD_UNIT.NATIVE_AD.equals(this.f16103b) && this.f16116o.containsKey(u1Var)) {
                return this.f16116o.get(u1Var).a(this.f16104c);
            }
            return -1;
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return -1;
        }
    }

    private void d() {
        HashMap map = new HashMap();
        this.f16116o = map;
        map.put(u1.INIT_STARTED, new a(IronSourceConstants.NT_MANAGER_INIT_STARTED, -1));
        this.f16116o.put(u1.INIT_ENDED, new a(IronSourceConstants.NT_MANAGER_INIT_ENDED, -1));
        this.f16116o.put(u1.PLACEMENT_CAPPED, new a(IronSourceConstants.NT_PLACEMENT_CAPPED, -1));
        this.f16116o.put(u1.AUCTION_REQUEST, new a(IronSourceConstants.NT_AUCTION_REQUEST, -1));
        this.f16116o.put(u1.AUCTION_SUCCESS, new a(IronSourceConstants.NT_AUCTION_SUCCESS, -1));
        this.f16116o.put(u1.AUCTION_FAILED, new a(IronSourceConstants.NT_AUCTION_FAILED, -1));
        this.f16116o.put(u1.AUCTION_FAILED_NO_CANDIDATES, new a(IronSourceConstants.NT_AUCTION_FAILED, -1));
        this.f16116o.put(u1.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.NT_AUCTION_REQUEST_WATERFALL, -1));
        this.f16116o.put(u1.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.NT_AUCTION_RESPONSE_WATERFALL, -1));
        this.f16116o.put(u1.INIT_SUCCESS, new a(-1, -1));
        this.f16116o.put(u1.INIT_FAILED, new a(-1, -1));
        this.f16116o.put(u1.AD_OPENED, new a(IronSourceConstants.NT_CALLBACK_SHOW, IronSourceConstants.NT_INSTANCE_SHOW));
        this.f16116o.put(u1.AD_CLICKED, new a(IronSourceConstants.NT_CALLBACK_CLICK, IronSourceConstants.NT_INSTANCE_CLICK));
        this.f16116o.put(u1.LOAD_AD, new a(4001, 4002));
        this.f16116o.put(u1.LOAD_AD_SUCCESS, new a(IronSourceConstants.NT_CALLBACK_LOAD_SUCCESS, 4005));
        this.f16116o.put(u1.LOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.NT_CALLBACK_LOAD_ERROR, IronSourceConstants.NT_INSTANCE_LOAD_ERROR));
        this.f16116o.put(u1.LOAD_AD_NO_FILL, new a(-1, IronSourceConstants.NT_INSTANCE_LOAD_NO_FILL));
        this.f16116o.put(u1.AD_FORMAT_CAPPED, new a(IronSourceConstants.NT_AD_UNIT_CAPPED, -1));
        this.f16116o.put(u1.COLLECT_TOKEN, new a(IronSourceConstants.NT_COLLECT_TOKENS, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN));
        this.f16116o.put(u1.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.NT_COLLECT_TOKENS_COMPLETED, -1));
        this.f16116o.put(u1.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.NT_COLLECT_TOKENS_FAILED, -1));
        this.f16116o.put(u1.INSTANCE_COLLECT_TOKEN, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN, -1));
        this.f16116o.put(u1.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_SUCCESS, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_SUCCESS));
        this.f16116o.put(u1.INSTANCE_COLLECT_TOKEN_FAILED, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_FAILED, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_FAILED));
        this.f16116o.put(u1.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_TIMED_OUT, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_TIMED_OUT));
        this.f16116o.put(u1.DESTROY_AD, new a(4100, IronSourceConstants.NT_INSTANCE_DESTROY));
        this.f16116o.put(u1.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_NT_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_NT_PROVIDER_SETTINGS_MISSING));
        this.f16116o.put(u1.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_NT_BIDDING_DATA_MISSING, IronSourceConstants.TROUBLESHOOTING_NT_BIDDING_DATA_MISSING));
        this.f16116o.put(u1.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_SUCCESS));
        this.f16116o.put(u1.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_FAILED));
        this.f16116o.put(u1.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_SUCCESS));
        this.f16116o.put(u1.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_FAILED));
        this.f16116o.put(u1.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_SUCCESS));
        this.f16116o.put(u1.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_FAILED));
        this.f16116o.put(u1.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_TIMEOUT));
        this.f16116o.put(u1.TROUBLESHOOT_UNEXPECTED_OPENED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_OPENED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_OPENED));
        this.f16116o.put(u1.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_NT_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_NT_INTERNAL_ERROR));
        this.f16116o.put(u1.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.f16116o.put(u1.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new a(88002, 88002));
        this.f16116o.put(u1.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_NT_NOTIFICATIONS_ERROR, -1));
    }

    void b() {
        c();
        e();
        a();
        d();
    }

    void c() {
        HashMap map = new HashMap();
        this.f16113l = map;
        map.put(u1.INIT_STARTED, new a(IronSourceConstants.IS_MANAGER_INIT_STARTED, -1));
        this.f16113l.put(u1.INIT_ENDED, new a(IronSourceConstants.IS_MANAGER_INIT_ENDED, -1));
        this.f16113l.put(u1.SESSION_CAPPED, new a(-1, IronSourceConstants.IS_CAP_SESSION));
        this.f16113l.put(u1.PLACEMENT_CAPPED, new a(IronSourceConstants.IS_CAP_PLACEMENT, -1));
        this.f16113l.put(u1.CHECK_PLACEMENT_CAPPED, new a(IronSourceConstants.IS_CHECK_PLACEMENT_CAPPED, -1));
        this.f16113l.put(u1.AUCTION_REQUEST, new a(2000, -1));
        this.f16113l.put(u1.AUCTION_SUCCESS, new a(IronSourceConstants.IS_AUCTION_SUCCESS, -1));
        this.f16113l.put(u1.AUCTION_FAILED, new a(2300, -1));
        this.f16113l.put(u1.AUCTION_FAILED_NO_CANDIDATES, new a(2300, -1));
        this.f16113l.put(u1.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.IS_AUCTION_REQUEST_WATERFALL, -1));
        this.f16113l.put(u1.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.IS_RESULT_WATERFALL, -1));
        this.f16113l.put(u1.INIT_SUCCESS, new a(-1, -1));
        this.f16113l.put(u1.INIT_FAILED, new a(-1, -1));
        this.f16113l.put(u1.SHOW_AD_SUCCESS, new a(IronSourceConstants.IS_CALLBACK_AD_DISPLAYED, 2202));
        this.f16113l.put(u1.AD_OPENED, new a(-1, 2005));
        this.f16113l.put(u1.AD_CLOSED, new a(IronSourceConstants.IS_CALLBACK_AD_CLOSED, 2204));
        this.f16113l.put(u1.AD_CLICKED, new a(IronSourceConstants.IS_CALLBACK_AD_CLICKED, 2006));
        this.f16113l.put(u1.AD_INFO_CHANGED, new a(IronSourceConstants.IS_CALLBACK_AD_INFO_CHANGED, -1));
        this.f16113l.put(u1.LOAD_AD, new a(2001, 2002));
        this.f16113l.put(u1.LOAD_AD_SUCCESS, new a(2004, 2003));
        this.f16113l.put(u1.LOAD_AD_FAILED_WITH_REASON, new a(2110, 2200));
        this.f16113l.put(u1.LOAD_AD_NO_FILL, new a(-1, 2213));
        this.f16113l.put(u1.SHOW_AD, new a(2100, 2201));
        this.f16113l.put(u1.SHOW_AD_FAILED, new a(IronSourceConstants.IS_CALLBACK_AD_SHOW_ERROR, 2203));
        this.f16113l.put(u1.AD_FORMAT_CAPPED, new a(2303, -1));
        this.f16113l.put(u1.AD_UNIT_CAPPED, new a(IronSourceConstants.IS_AD_UNIT_CAPPED, -1));
        this.f16113l.put(u1.COLLECT_TOKEN, new a(IronSourceConstants.IS_COLLECT_TOKENS, -1));
        this.f16113l.put(u1.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.IS_COLLECT_TOKENS_COMPLETED, -1));
        this.f16113l.put(u1.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.IS_COLLECT_TOKENS_FAILED, -1));
        this.f16113l.put(u1.INSTANCE_COLLECT_TOKEN, new a(2020, -1));
        this.f16113l.put(u1.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_SUCCESS, -1));
        this.f16113l.put(u1.INSTANCE_COLLECT_TOKEN_FAILED, new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_FAILED, -1));
        this.f16113l.put(u1.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_TIMED_OUT, -1));
        this.f16113l.put(u1.AD_READY_TRUE, new a(IronSourceConstants.IS_CHECK_READY_TRUE, -1));
        this.f16113l.put(u1.AD_READY_FALSE, new a(IronSourceConstants.IS_CHECK_READY_FALSE, -1));
        this.f16113l.put(u1.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_IS_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_IS_PROVIDER_SETTINGS_MISSING));
        this.f16113l.put(u1.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_IS_BIDDING_DATA_MISSING, IronSourceConstants.TROUBLESHOOTING_IS_BIDDING_DATA_MISSING));
        this.f16113l.put(u1.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_SUCCESS));
        this.f16113l.put(u1.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_FAILED));
        this.f16113l.put(u1.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_SUCCESS));
        this.f16113l.put(u1.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_FAILED));
        this.f16113l.put(u1.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_SUCCESS));
        this.f16113l.put(u1.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_FAILED));
        this.f16113l.put(u1.TROUBLESHOOT_UNEXPECTED_SHOW_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_SHOW_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_SHOW_FAILED));
        this.f16113l.put(u1.TROUBLESHOOT_UNEXPECTED_CLOSED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_CLOSED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_CLOSED));
        this.f16113l.put(u1.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_TIMEOUT));
        this.f16113l.put(u1.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_IS_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_IS_INTERNAL_ERROR));
        this.f16113l.put(u1.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.f16113l.put(u1.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new a(88002, 88002));
        this.f16113l.put(u1.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_IS_NOTIFICATIONS_ERROR, -1));
        this.f16113l.put(u1.TROUBLESHOOT_LOAD, new a(IronSourceConstants.TROUBLESHOOTING_IS_LOAD, -1));
        this.f16113l.put(u1.TROUBLESHOOT_LOAD_WHILE_LOADED, new a(IronSourceConstants.TROUBLESHOOTING_IS_LOAD_WHILE_LOADED, -1));
        this.f16113l.put(u1.TROUBLESHOOT_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_LOAD_SUCCESS, -1));
        this.f16113l.put(u1.TROUBLESHOOT_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_LOAD_FAILED, -1));
        this.f16113l.put(u1.TROUBLESHOOT_SHOW, new a(IronSourceConstants.TROUBLESHOOTING_IS_SHOW, -1));
        this.f16113l.put(u1.TROUBLESHOOT_SHOW_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_SHOW_SUCCESS, -1));
        this.f16113l.put(u1.TROUBLESHOOT_SHOW_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_SHOW_FAILED, -1));
    }

    void e() {
        HashMap map = new HashMap();
        this.f16114m = map;
        map.put(u1.INIT_STARTED, new a(IronSourceConstants.RV_MANAGER_INIT_STARTED, -1));
        this.f16114m.put(u1.INIT_ENDED, new a(IronSourceConstants.RV_MANAGER_INIT_ENDED, -1));
        this.f16114m.put(u1.SESSION_CAPPED, new a(-1, IronSourceConstants.RV_CAP_SESSION));
        this.f16114m.put(u1.PLACEMENT_CAPPED, new a(IronSourceConstants.RV_CAP_PLACEMENT, -1));
        this.f16114m.put(u1.AUCTION_REQUEST, new a(IronSourceConstants.RV_AUCTION_REQUEST, -1));
        this.f16114m.put(u1.AUCTION_SUCCESS, new a(IronSourceConstants.RV_AUCTION_SUCCESS, -1));
        this.f16114m.put(u1.AUCTION_FAILED, new a(1301, -1));
        this.f16114m.put(u1.AUCTION_FAILED_NO_CANDIDATES, new a(1301, -1));
        this.f16114m.put(u1.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL, -1));
        this.f16114m.put(u1.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.RV_AUCTION_RESPONSE_WATERFALL, -1));
        this.f16114m.put(u1.INIT_SUCCESS, new a(-1, -1));
        this.f16114m.put(u1.INIT_FAILED, new a(-1, -1));
        this.f16114m.put(u1.AD_VISIBLE, new a(-1, 1206));
        this.f16114m.put(u1.AD_OPENED, new a(-1, 1005));
        this.f16114m.put(u1.AD_CLOSED, new a(-1, 1203));
        this.f16114m.put(u1.AD_STARTED, new a(-1, IronSourceConstants.RV_INSTANCE_STARTED));
        this.f16114m.put(u1.AD_ENDED, new a(-1, IronSourceConstants.RV_INSTANCE_ENDED));
        this.f16114m.put(u1.AD_CLICKED, new a(-1, 1006));
        this.f16114m.put(u1.AD_REWARDED, new a(-1, 1010));
        this.f16114m.put(u1.AD_AVAILABILITY_CHANGED_TRUE, new a(IronSourceConstants.RV_CALLBACK_AVAILABILITY_TRUE, IronSourceConstants.RV_INSTANCE_AVAILABILITY_TRUE));
        this.f16114m.put(u1.AD_AVAILABILITY_CHANGED_FALSE, new a(IronSourceConstants.RV_CALLBACK_AVAILABILITY_FALSE, IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE));
        this.f16114m.put(u1.LOAD_AD, new a(1000, 1001));
        this.f16114m.put(u1.LOAD_AD_SUCCESS, new a(1003, 1002));
        this.f16114m.put(u1.LOAD_AD_FAILED, new a(-1, 1200));
        this.f16114m.put(u1.LOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.RV_MEDIATION_LOAD_ERROR, IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON));
        this.f16114m.put(u1.LOAD_AD_NO_FILL, new a(-1, 1213));
        this.f16114m.put(u1.SHOW_AD, new a(IronSourceConstants.RV_API_SHOW_CALLED, 1201));
        this.f16114m.put(u1.SHOW_AD_CHANCE, new a(-1, IronSourceConstants.RV_INSTANCE_SHOW_CHANCE));
        this.f16114m.put(u1.SHOW_AD_FAILED, new a(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, 1202));
        this.f16114m.put(u1.AD_FORMAT_CAPPED, new a(IronSourceConstants.RV_AD_UNIT_CAPPED, -1));
        this.f16114m.put(u1.COLLECT_TOKEN, new a(IronSourceConstants.RV_COLLECT_TOKENS, -1));
        this.f16114m.put(u1.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.RV_COLLECT_TOKENS_COMPLETED, -1));
        this.f16114m.put(u1.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.RV_COLLECT_TOKENS_FAILED, -1));
        this.f16114m.put(u1.INSTANCE_COLLECT_TOKEN, new a(1020, -1));
        this.f16114m.put(u1.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(1021, 1021));
        this.f16114m.put(u1.INSTANCE_COLLECT_TOKEN_FAILED, new a(1022, 1022));
        this.f16114m.put(u1.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(1023, 1023));
        this.f16114m.put(u1.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_RV_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_RV_PROVIDER_SETTINGS_MISSING));
        this.f16114m.put(u1.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_RV_BIDDING_DATA_MISSING, IronSourceConstants.TROUBLESHOOTING_RV_BIDDING_DATA_MISSING));
        this.f16114m.put(u1.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_SUCCESS));
        this.f16114m.put(u1.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_FAILED));
        this.f16114m.put(u1.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_SUCCESS));
        this.f16114m.put(u1.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_FAILED));
        this.f16114m.put(u1.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_SUCCESS));
        this.f16114m.put(u1.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_FAILED));
        this.f16114m.put(u1.TROUBLESHOOT_UNEXPECTED_SHOW_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_SHOW_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_SHOW_FAILED));
        this.f16114m.put(u1.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_TIMEOUT));
        this.f16114m.put(u1.TROUBLESHOOT_UNEXPECTED_CLOSED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_CLOSED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_CLOSED));
        this.f16114m.put(u1.TROUBLESHOOT_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED));
        this.f16114m.put(u1.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_RV_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_RV_INTERNAL_ERROR));
        this.f16114m.put(u1.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.f16114m.put(u1.TROUBLESHOOT_WATERFALL_OVERHEAD, new a(IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD, IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD));
        this.f16114m.put(u1.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, -1));
        this.f16114m.put(u1.TROUBLESHOOT_AD_EXPIRED, new a(IronSourceConstants.TROUBLESHOOTING_RV_AD_EXPIRED, IronSourceConstants.TROUBLESHOOTING_RV_AD_EXPIRED));
    }

    public void f() {
        this.f16105d = null;
        this.f16109h = null;
        this.f16110i = null;
        this.f16107f = null;
        this.f16108g = null;
        this.f16111j = null;
        this.f16112k = null;
    }

    public x1(IronSource.AD_UNIT ad_unit, b bVar, w1 w1Var, m7 m7Var) {
        this.f16102a = -1;
        this.f16103b = ad_unit;
        this.f16104c = bVar;
        this.f16105d = w1Var;
        this.f16106e = m7Var == null ? a(ad_unit) : m7Var;
        b();
        this.f16107f = new ug(this);
        this.f16108g = new sk(this);
        this.f16109h = new pt(this);
        this.f16110i = new k4(this);
        this.f16111j = new j0(this);
        this.f16112k = new ut(this);
    }

    private static m7 a(IronSource.AD_UNIT ad_unit) {
        return ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO) ? rp.i() : ji.i();
    }

    void a() {
        HashMap map = new HashMap();
        this.f16115n = map;
        map.put(u1.INIT_STARTED, new a(IronSourceConstants.BN_MANAGER_INIT_STARTED, -1));
        this.f16115n.put(u1.INIT_ENDED, new a(IronSourceConstants.BN_MANAGER_INIT_ENDED, -1));
        this.f16115n.put(u1.PLACEMENT_CAPPED, new a(IronSourceConstants.BN_PLACEMENT_CAPPED, -1));
        this.f16115n.put(u1.AUCTION_REQUEST, new a(IronSourceConstants.BN_AUCTION_REQUEST, -1));
        this.f16115n.put(u1.AUCTION_SUCCESS, new a(IronSourceConstants.BN_AUCTION_SUCCESS, -1));
        this.f16115n.put(u1.AUCTION_FAILED, new a(IronSourceConstants.BN_AUCTION_FAILED, -1));
        this.f16115n.put(u1.AUCTION_FAILED_NO_CANDIDATES, new a(IronSourceConstants.BN_AUCTION_FAILED, -1));
        this.f16115n.put(u1.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.BN_AUCTION_REQUEST_WATERFALL, -1));
        this.f16115n.put(u1.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.BN_AUCTION_RESPONSE_WATERFALL, -1));
        this.f16115n.put(u1.INIT_SUCCESS, new a(-1, -1));
        this.f16115n.put(u1.INIT_FAILED, new a(-1, -1));
        this.f16115n.put(u1.AD_OPENED, new a(IronSourceConstants.BN_CALLBACK_SHOW, 3009));
        this.f16115n.put(u1.AD_CLICKED, new a(IronSourceConstants.BN_CALLBACK_CLICK, 3008));
        this.f16115n.put(u1.LOAD_AD, new a(3001, 3002));
        this.f16115n.put(u1.RELOAD_AD, new a(IronSourceConstants.BN_RELOAD, IronSourceConstants.BN_INSTANCE_RELOAD));
        this.f16115n.put(u1.LOAD_AD_SUCCESS, new a(IronSourceConstants.BN_CALLBACK_LOAD_SUCCESS, 3005));
        this.f16115n.put(u1.RELOAD_AD_SUCCESS, new a(IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS, IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS));
        this.f16115n.put(u1.LOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, 3300));
        this.f16115n.put(u1.RELOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.BN_CALLBACK_RELOAD_ERROR, IronSourceConstants.BN_INSTANCE_RELOAD_ERROR));
        this.f16115n.put(u1.LOAD_AD_NO_FILL, new a(-1, 3306));
        this.f16115n.put(u1.RELOAD_AD_NO_FILL, new a(-1, IronSourceConstants.BN_INSTANCE_RELOAD_NO_FILL));
        this.f16115n.put(u1.AD_FORMAT_CAPPED, new a(IronSourceConstants.BN_AD_UNIT_CAPPED, -1));
        this.f16115n.put(u1.COLLECT_TOKEN, new a(IronSourceConstants.BN_COLLECT_TOKENS, -1));
        this.f16115n.put(u1.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.BN_COLLECT_TOKENS_COMPLETED, -1));
        this.f16115n.put(u1.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.BN_COLLECT_TOKENS_FAILED, -1));
        this.f16115n.put(u1.INSTANCE_COLLECT_TOKEN, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN, -1));
        this.f16115n.put(u1.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_SUCCESS, IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_SUCCESS));
        this.f16115n.put(u1.INSTANCE_COLLECT_TOKEN_FAILED, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_FAILED, IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_FAILED));
        this.f16115n.put(u1.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_TIMED_OUT, IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_TIMED_OUT));
        this.f16115n.put(u1.DESTROY_AD, new a(IronSourceConstants.BN_DESTROY, 3305));
        this.f16115n.put(u1.SKIP_RELOAD_AD, new a(IronSourceConstants.BN_SKIP_RELOAD, -1));
        this.f16115n.put(u1.AD_LEFT_APPLICATION, new a(IronSourceConstants.BN_CALLBACK_LEAVE_APP, 3304));
        this.f16115n.put(u1.AD_PRESENT_SCREEN, new a(IronSourceConstants.BN_CALLBACK_PRESENT_SCREEN, IronSourceConstants.BN_INSTANCE_PRESENT_SCREEN));
        this.f16115n.put(u1.AD_DISMISS_SCREEN, new a(IronSourceConstants.BN_CALLBACK_DISMISS_SCREEN, IronSourceConstants.BN_INSTANCE_DISMISS_SCREEN));
        this.f16115n.put(u1.AD_VIEW_BOUND, new a(IronSourceConstants.BN_BOUND, IronSourceConstants.BN_INSTANCE_BOUND));
        this.f16115n.put(u1.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_BN_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_BN_PROVIDER_SETTINGS_MISSING));
        this.f16115n.put(u1.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_BN_BIDDING_DATA_MISSING, IronSourceConstants.TROUBLESHOOTING_BN_BIDDING_DATA_MISSING));
        this.f16115n.put(u1.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_SUCCESS));
        this.f16115n.put(u1.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_FAILED));
        this.f16115n.put(u1.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_SUCCESS));
        this.f16115n.put(u1.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_FAILED));
        this.f16115n.put(u1.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_SUCCESS));
        this.f16115n.put(u1.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_FAILED));
        this.f16115n.put(u1.TROUBLESHOOT_UNEXPECTED_RELOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_SUCCESS));
        this.f16115n.put(u1.TROUBLESHOOT_UNEXPECTED_RELOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_FAILED));
        this.f16115n.put(u1.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_TIMEOUT));
        this.f16115n.put(u1.TROUBLESHOOT_UNEXPECTED_OPENED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_OPENED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_OPENED));
        this.f16115n.put(u1.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR));
        this.f16115n.put(u1.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.f16115n.put(u1.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new a(88002, 88002));
        this.f16115n.put(u1.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_BN_NOTIFICATIONS_ERROR, -1));
        this.f16115n.put(u1.TROUBLESHOOT_BN_RELOAD_EXCEPTION, new a(IronSourceConstants.TROUBLESHOOTING_BN_RELOAD_EXCEPTION, -1));
        this.f16115n.put(u1.TROUBLESHOOT_IMPRESSION_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_BN_IMPRESSION_TIMEOUT_REACHED, -1));
        this.f16115n.put(u1.TROUBLESHOOT_BANNER_REFRESH_PAUSED, new a(IronSourceConstants.TROUBLESHOOT_BN_BANNER_REFRESH_PAUSED, -1));
        this.f16115n.put(u1.TROUBLESHOOT_BANNER_REFRESH_RESUMED, new a(IronSourceConstants.TROUBLESHOOT_BN_BANNER_REFRESH_RESUMED, -1));
        this.f16115n.put(u1.TROUBLESHOOT_BANNER_REFRESH_TRIGGER_PAUSE, new a(IronSourceConstants.TROUBLESHOOT_BN_BANNER_REFRESH_TRIGGER_PAUSE, -1));
        this.f16115n.put(u1.TROUBLESHOOT_BANNER_REFRESH_TRIGGER_RESUME, new a(IronSourceConstants.TROUBLESHOOT_BN_BANNER_REFRESH_TRIGGER_RESUME, -1));
    }

    protected void a(u1 u1Var, Map<String, Object> map) {
        a(u1Var, map, Calendar.getInstance().getTimeInMillis());
    }

    public void a(u1 u1Var, Map<String, Object> map, long j10) {
        int iA = a(u1Var);
        if (-1 == iA) {
            return;
        }
        HashMap map2 = new HashMap();
        w1 w1Var = this.f16105d;
        if (w1Var != null) {
            map2.putAll(w1Var.a(u1Var));
        }
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        this.f16106e.a(new kb(iA, j10, new JSONObject(map2)));
    }
}
