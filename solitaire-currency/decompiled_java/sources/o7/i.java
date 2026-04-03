package o7;

import com.vungle.ads.internal.util.r;
import da.c0;
import da.d0;
import da.i1;
import da.l0;
import da.s1;
import da.w1;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.o;

/* JADX INFO: compiled from: SessionContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class i {

    @NotNull
    public static final b Companion = new b(null);

    @Nullable
    private List<String> friends;

    @Nullable
    private Float healthPercentile;

    @Nullable
    private Float inGamePurchasesUSD;

    @Nullable
    private Float levelPercentile;

    @Nullable
    private String page;

    @Nullable
    private Integer sessionDuration;

    @Nullable
    private Integer sessionStartTime;

    @Nullable
    private Integer signupDate;

    @Nullable
    private Integer timeSpent;

    @Nullable
    private String userID;

    @Nullable
    private Float userLevelPercentile;

    @Nullable
    private Float userScorePercentile;

    /* JADX INFO: compiled from: SessionContext.kt */
    public static final class a implements d0<i> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.SessionContext", aVar, 12);
            pluginGeneratedSerialDescriptor.k("level_percentile", true);
            pluginGeneratedSerialDescriptor.k("page", true);
            pluginGeneratedSerialDescriptor.k("time_spent", true);
            pluginGeneratedSerialDescriptor.k("signup_date", true);
            pluginGeneratedSerialDescriptor.k("user_score_percentile", true);
            pluginGeneratedSerialDescriptor.k("user_id", true);
            pluginGeneratedSerialDescriptor.k("friends", true);
            pluginGeneratedSerialDescriptor.k("user_level_percentile", true);
            pluginGeneratedSerialDescriptor.k("health_percentile", true);
            pluginGeneratedSerialDescriptor.k("session_start_time", true);
            pluginGeneratedSerialDescriptor.k("session_duration", true);
            pluginGeneratedSerialDescriptor.k("in_game_purchases_usd", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            c0 c0Var = c0.f24548a;
            w1 w1Var = w1.f24648a;
            l0 l0Var = l0.f24594a;
            return new KSerializer[]{aa.a.s(c0Var), aa.a.s(w1Var), aa.a.s(l0Var), aa.a.s(l0Var), aa.a.s(c0Var), aa.a.s(w1Var), aa.a.s(new da.f(w1Var)), aa.a.s(c0Var), aa.a.s(c0Var), aa.a.s(l0Var), aa.a.s(l0Var), aa.a.s(c0Var)};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        @Override // z9.b
        @NotNull
        public i deserialize(@NotNull Decoder decoder) {
            Object objK;
            Object objK2;
            Object obj;
            Object objK3;
            Object objK4;
            Object objK5;
            Object objK6;
            Object objK7;
            Object objK8;
            int i10;
            Object objK9;
            Object objK10;
            Object objK11;
            Object obj2;
            Object obj3;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            Object objK12 = null;
            if (cVarB.p()) {
                c0 c0Var = c0.f24548a;
                objK11 = cVarB.k(descriptor2, 0, c0Var, null);
                w1 w1Var = w1.f24648a;
                Object objK13 = cVarB.k(descriptor2, 1, w1Var, null);
                l0 l0Var = l0.f24594a;
                objK7 = cVarB.k(descriptor2, 2, l0Var, null);
                objK10 = cVarB.k(descriptor2, 3, l0Var, null);
                Object objK14 = cVarB.k(descriptor2, 4, c0Var, null);
                objK6 = cVarB.k(descriptor2, 5, w1Var, null);
                objK9 = cVarB.k(descriptor2, 6, new da.f(w1Var), null);
                objK8 = cVarB.k(descriptor2, 7, c0Var, null);
                objK4 = cVarB.k(descriptor2, 8, c0Var, null);
                objK = cVarB.k(descriptor2, 9, l0Var, null);
                objK3 = cVarB.k(descriptor2, 10, l0Var, null);
                objK5 = cVarB.k(descriptor2, 11, c0Var, null);
                obj = objK13;
                objK2 = objK14;
                i10 = 4095;
            } else {
                boolean z10 = true;
                int i11 = 0;
                Object objK15 = null;
                Object objK16 = null;
                Object objK17 = null;
                objK = null;
                Object objK18 = null;
                Object objK19 = null;
                Object objK20 = null;
                Object objK21 = null;
                Object objK22 = null;
                objK2 = null;
                Object objK23 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    switch (iO) {
                        case -1:
                            obj2 = objK15;
                            z10 = false;
                            objK15 = obj2;
                            break;
                        case 0:
                            obj2 = objK15;
                            objK12 = cVarB.k(descriptor2, 0, c0.f24548a, objK12);
                            i11 |= 1;
                            objK15 = obj2;
                            break;
                        case 1:
                            obj3 = objK12;
                            objK15 = cVarB.k(descriptor2, 1, w1.f24648a, objK15);
                            i11 |= 2;
                            objK12 = obj3;
                            break;
                        case 2:
                            obj3 = objK12;
                            objK16 = cVarB.k(descriptor2, 2, l0.f24594a, objK16);
                            i11 |= 4;
                            objK12 = obj3;
                            break;
                        case 3:
                            obj3 = objK12;
                            objK23 = cVarB.k(descriptor2, 3, l0.f24594a, objK23);
                            i11 |= 8;
                            objK12 = obj3;
                            break;
                        case 4:
                            obj3 = objK12;
                            objK2 = cVarB.k(descriptor2, 4, c0.f24548a, objK2);
                            i11 |= 16;
                            objK12 = obj3;
                            break;
                        case 5:
                            obj3 = objK12;
                            objK22 = cVarB.k(descriptor2, 5, w1.f24648a, objK22);
                            i11 |= 32;
                            objK12 = obj3;
                            break;
                        case 6:
                            obj3 = objK12;
                            objK19 = cVarB.k(descriptor2, 6, new da.f(w1.f24648a), objK19);
                            i11 |= 64;
                            objK12 = obj3;
                            break;
                        case 7:
                            obj3 = objK12;
                            objK21 = cVarB.k(descriptor2, 7, c0.f24548a, objK21);
                            i11 |= 128;
                            objK12 = obj3;
                            break;
                        case 8:
                            obj3 = objK12;
                            objK18 = cVarB.k(descriptor2, 8, c0.f24548a, objK18);
                            i11 |= 256;
                            objK12 = obj3;
                            break;
                        case 9:
                            obj3 = objK12;
                            objK = cVarB.k(descriptor2, 9, l0.f24594a, objK);
                            i11 |= 512;
                            objK12 = obj3;
                            break;
                        case 10:
                            obj3 = objK12;
                            objK17 = cVarB.k(descriptor2, 10, l0.f24594a, objK17);
                            i11 |= 1024;
                            objK12 = obj3;
                            break;
                        case 11:
                            objK20 = cVarB.k(descriptor2, 11, c0.f24548a, objK20);
                            i11 |= 2048;
                            objK12 = objK12;
                            break;
                        default:
                            throw new o(iO);
                    }
                }
                obj = objK15;
                objK3 = objK17;
                objK4 = objK18;
                objK5 = objK20;
                objK6 = objK22;
                objK7 = objK16;
                objK8 = objK21;
                i10 = i11;
                objK9 = objK19;
                objK10 = objK23;
                objK11 = objK12;
            }
            cVarB.c(descriptor2);
            return new i(i10, (Float) objK11, (String) obj, (Integer) objK7, (Integer) objK10, (Float) objK2, (String) objK6, (List) objK9, (Float) objK8, (Float) objK4, (Integer) objK, (Integer) objK3, (Float) objK5, null);
        }

        @Override // z9.j
        public void serialize(@NotNull Encoder encoder, @NotNull i value) {
            t.i(encoder, "encoder");
            t.i(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.d dVarB = encoder.b(descriptor2);
            i.write$Self(value, dVarB, descriptor2);
            dVarB.c(descriptor2);
        }
    }

    /* JADX INFO: compiled from: SessionContext.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<i> serializer() {
            return a.INSTANCE;
        }
    }

    public i() {
    }

    public static final void write$Self(@NotNull i self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        if (output.z(serialDesc, 0) || self.levelPercentile != null) {
            output.h(serialDesc, 0, c0.f24548a, self.levelPercentile);
        }
        if (output.z(serialDesc, 1) || self.page != null) {
            output.h(serialDesc, 1, w1.f24648a, self.page);
        }
        if (output.z(serialDesc, 2) || self.timeSpent != null) {
            output.h(serialDesc, 2, l0.f24594a, self.timeSpent);
        }
        if (output.z(serialDesc, 3) || self.signupDate != null) {
            output.h(serialDesc, 3, l0.f24594a, self.signupDate);
        }
        if (output.z(serialDesc, 4) || self.userScorePercentile != null) {
            output.h(serialDesc, 4, c0.f24548a, self.userScorePercentile);
        }
        if (output.z(serialDesc, 5) || self.userID != null) {
            output.h(serialDesc, 5, w1.f24648a, self.userID);
        }
        if (output.z(serialDesc, 6) || self.friends != null) {
            output.h(serialDesc, 6, new da.f(w1.f24648a), self.friends);
        }
        if (output.z(serialDesc, 7) || self.userLevelPercentile != null) {
            output.h(serialDesc, 7, c0.f24548a, self.userLevelPercentile);
        }
        if (output.z(serialDesc, 8) || self.healthPercentile != null) {
            output.h(serialDesc, 8, c0.f24548a, self.healthPercentile);
        }
        if (output.z(serialDesc, 9) || self.sessionStartTime != null) {
            output.h(serialDesc, 9, l0.f24594a, self.sessionStartTime);
        }
        if (output.z(serialDesc, 10) || self.sessionDuration != null) {
            output.h(serialDesc, 10, l0.f24594a, self.sessionDuration);
        }
        if (output.z(serialDesc, 11) || self.inGamePurchasesUSD != null) {
            output.h(serialDesc, 11, c0.f24548a, self.inGamePurchasesUSD);
        }
    }

    @NotNull
    public final i setFriends(@Nullable List<String> list) {
        this.friends = list != null ? kotlin.collections.d0.R0(list) : null;
        return this;
    }

    @NotNull
    public final i setHealthPercentile(float f10) {
        if (r.INSTANCE.isInRange(f10, 0.0f, 100.0f)) {
            this.healthPercentile = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final i setInGamePurchasesUSD(float f10) {
        if (r.isInRange$default(r.INSTANCE, f10, 0.0f, 0.0f, 4, (Object) null)) {
            this.inGamePurchasesUSD = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final i setLevelPercentile(float f10) {
        if (r.INSTANCE.isInRange(f10, 0.0f, 100.0f)) {
            this.levelPercentile = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final i setPage(@NotNull String page) {
        t.i(page, "page");
        this.page = page;
        return this;
    }

    @NotNull
    public final i setSessionDuration(int i10) {
        this.sessionDuration = Integer.valueOf(i10);
        return this;
    }

    @NotNull
    public final i setSessionStartTime(int i10) {
        this.sessionStartTime = Integer.valueOf(i10);
        return this;
    }

    @NotNull
    public final i setSignupDate(int i10) {
        this.signupDate = Integer.valueOf(i10);
        return this;
    }

    @NotNull
    public final i setTimeSpent(int i10) {
        this.timeSpent = Integer.valueOf(i10);
        return this;
    }

    @NotNull
    public final i setUserID(@NotNull String userID) {
        t.i(userID, "userID");
        this.userID = userID;
        return this;
    }

    @NotNull
    public final i setUserLevelPercentile(float f10) {
        if (r.INSTANCE.isInRange(f10, 0.0f, 100.0f)) {
            this.userLevelPercentile = Float.valueOf(f10);
        }
        return this;
    }

    @NotNull
    public final i setUserScorePercentile(float f10) {
        if (r.INSTANCE.isInRange(f10, 0.0f, 100.0f)) {
            this.userScorePercentile = Float.valueOf(f10);
        }
        return this;
    }

    public /* synthetic */ i(int i10, Float f10, String str, Integer num, Integer num2, Float f11, String str2, List list, Float f12, Float f13, Integer num3, Integer num4, Float f14, s1 s1Var) {
        if ((i10 & 0) != 0) {
            i1.a(i10, 0, a.INSTANCE.getDescriptor());
        }
        if ((i10 & 1) == 0) {
            this.levelPercentile = null;
        } else {
            this.levelPercentile = f10;
        }
        if ((i10 & 2) == 0) {
            this.page = null;
        } else {
            this.page = str;
        }
        if ((i10 & 4) == 0) {
            this.timeSpent = null;
        } else {
            this.timeSpent = num;
        }
        if ((i10 & 8) == 0) {
            this.signupDate = null;
        } else {
            this.signupDate = num2;
        }
        if ((i10 & 16) == 0) {
            this.userScorePercentile = null;
        } else {
            this.userScorePercentile = f11;
        }
        if ((i10 & 32) == 0) {
            this.userID = null;
        } else {
            this.userID = str2;
        }
        if ((i10 & 64) == 0) {
            this.friends = null;
        } else {
            this.friends = list;
        }
        if ((i10 & 128) == 0) {
            this.userLevelPercentile = null;
        } else {
            this.userLevelPercentile = f12;
        }
        if ((i10 & 256) == 0) {
            this.healthPercentile = null;
        } else {
            this.healthPercentile = f13;
        }
        if ((i10 & 512) == 0) {
            this.sessionStartTime = null;
        } else {
            this.sessionStartTime = num3;
        }
        if ((i10 & 1024) == 0) {
            this.sessionDuration = null;
        } else {
            this.sessionDuration = num4;
        }
        if ((i10 & 2048) == 0) {
            this.inGamePurchasesUSD = null;
        } else {
            this.inGamePurchasesUSD = f14;
        }
    }

    private static /* synthetic */ void getFriends$annotations() {
    }

    private static /* synthetic */ void getHealthPercentile$annotations() {
    }

    private static /* synthetic */ void getInGamePurchasesUSD$annotations() {
    }

    private static /* synthetic */ void getLevelPercentile$annotations() {
    }

    private static /* synthetic */ void getPage$annotations() {
    }

    private static /* synthetic */ void getSessionDuration$annotations() {
    }

    private static /* synthetic */ void getSessionStartTime$annotations() {
    }

    private static /* synthetic */ void getSignupDate$annotations() {
    }

    private static /* synthetic */ void getTimeSpent$annotations() {
    }

    private static /* synthetic */ void getUserID$annotations() {
    }

    private static /* synthetic */ void getUserLevelPercentile$annotations() {
    }

    private static /* synthetic */ void getUserScorePercentile$annotations() {
    }
}
