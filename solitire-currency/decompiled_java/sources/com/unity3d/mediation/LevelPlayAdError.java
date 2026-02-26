package com.unity3d.mediation;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LevelPlayAdError {

    @NotNull
    public static final a Companion = new a(null);
    public static final int ERROR_CODE_INVALID_AD_UNIT_ID = 626;
    public static final int ERROR_CODE_IS_LOAD_FAILED_ALREADY_CALLED = 627;
    public static final int ERROR_CODE_LOAD_BEFORE_INIT_SUCCESS_CALLBACK = 625;
    public static final int ERROR_CODE_LOAD_WHILE_SHOW = 629;
    public static final int ERROR_CODE_NO_AD_UNIT_ID_SPECIFIED = 624;
    public static final int ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK = 628;
    public static final int ERROR_CODE_SHOW_WHILE_SHOW = 630;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final IronSourceError f23882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f23883b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public LevelPlayAdError(@Nullable IronSourceError ironSourceError, @Nullable String str) {
        this.f23882a = ironSourceError;
        this.f23883b = str;
    }

    @Nullable
    public final String getAdUnitId() {
        return this.f23883b;
    }

    public final int getErrorCode() {
        IronSourceError ironSourceError = this.f23882a;
        if (ironSourceError != null) {
            return ironSourceError.getErrorCode();
        }
        return 0;
    }

    @NotNull
    public final String getErrorMessage() {
        IronSourceError ironSourceError = this.f23882a;
        String errorMessage = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
        return errorMessage == null ? "" : errorMessage;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("adUnitId: ");
        sb.append(this.f23883b);
        sb.append(' ');
        IronSourceError ironSourceError = this.f23882a;
        sb.append(ironSourceError != null ? ironSourceError.toString() : null);
        return sb.toString();
    }

    public /* synthetic */ LevelPlayAdError(IronSourceError ironSourceError, String str, int i10, k kVar) {
        this(ironSourceError, (i10 & 2) != 0 ? null : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayAdError(@NotNull String adUnitId, int i10, @NotNull String errorMessage) {
        this(new IronSourceError(i10, errorMessage), adUnitId);
        t.i(adUnitId, "adUnitId");
        t.i(errorMessage, "errorMessage");
    }
}
