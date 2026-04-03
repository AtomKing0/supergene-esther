package com.unity3d.mediation;

import com.unity3d.mediation.LevelPlay;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LevelPlayInitRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f23904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f23905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<LevelPlay.AdFormat> f23906c;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f23907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private String f23908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private List<? extends LevelPlay.AdFormat> f23909c;

        public Builder(@NotNull String appKey) {
            t.i(appKey, "appKey");
            this.f23907a = appKey;
        }

        @NotNull
        public final LevelPlayInitRequest build() {
            String str = this.f23907a;
            String str2 = this.f23908b;
            List<? extends LevelPlay.AdFormat> listL = this.f23909c;
            if (listL == null) {
                listL = v.l();
            }
            return new LevelPlayInitRequest(str, str2, listL, null);
        }

        @NotNull
        public final String getAppKey() {
            return this.f23907a;
        }

        @NotNull
        public final Builder withLegacyAdFormats(@NotNull List<? extends LevelPlay.AdFormat> legacyAdFormats) {
            t.i(legacyAdFormats, "legacyAdFormats");
            this.f23909c = legacyAdFormats;
            return this;
        }

        @NotNull
        public final Builder withUserId(@NotNull String userId) {
            t.i(userId, "userId");
            this.f23908b = userId;
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LevelPlayInitRequest(String str, String str2, List<? extends LevelPlay.AdFormat> list) {
        this.f23904a = str;
        this.f23905b = str2;
        this.f23906c = list;
    }

    @NotNull
    public final String getAppKey() {
        return this.f23904a;
    }

    @NotNull
    public final List<LevelPlay.AdFormat> getLegacyAdFormats() {
        return this.f23906c;
    }

    @Nullable
    public final String getUserId() {
        return this.f23905b;
    }

    public /* synthetic */ LevelPlayInitRequest(String str, String str2, List list, k kVar) {
        this(str, str2, list);
    }
}
