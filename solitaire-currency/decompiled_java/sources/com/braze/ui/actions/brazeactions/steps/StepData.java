package com.braze.ui.actions.brazeactions.steps;

import androidx.annotation.VisibleForTesting;
import com.braze.enums.Channel;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import h9.a;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: StepData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StepData {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final l args$delegate;

    @NotNull
    private final Channel channel;

    @NotNull
    private final l firstArg$delegate;

    @NotNull
    private final l secondArg$delegate;

    @NotNull
    private final JSONObject srcJson;

    /* JADX INFO: compiled from: StepData.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.brazeactions.steps.StepData$isArgCountInBounds$1, reason: invalid class name */
    /* JADX INFO: compiled from: StepData.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        final /* synthetic */ int $fixedArgCount;
        final /* synthetic */ StepData this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i10, StepData stepData) {
            super(0);
            this.$fixedArgCount = i10;
            this.this$0 = stepData;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Expected " + this.$fixedArgCount + " arguments. Got: " + this.this$0.getArgs();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.brazeactions.steps.StepData$isArgCountInBounds$2, reason: invalid class name */
    /* JADX INFO: compiled from: StepData.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        final /* synthetic */ i $rangedArgCount;
        final /* synthetic */ StepData this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(i iVar, StepData stepData) {
            super(0);
            this.$rangedArgCount = iVar;
            this.this$0 = stepData;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Expected " + this.$rangedArgCount + " arguments. Got: " + this.this$0.getArgs();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.brazeactions.steps.StepData$isArgOptionalJsonObject$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StepData.kt */
    static final class C11491 extends v implements a<String> {
        final /* synthetic */ int $index;
        final /* synthetic */ StepData this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11491(int i10, StepData stepData) {
            super(0);
            this.$index = i10;
            this.this$0 = stepData;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Argument [" + this.$index + "] is not a JSONObject. Source: " + this.this$0.getSrcJson();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.brazeactions.steps.StepData$isArgString$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StepData.kt */
    static final class C11501 extends v implements a<String> {
        final /* synthetic */ int $index;
        final /* synthetic */ StepData this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11501(int i10, StepData stepData) {
            super(0);
            this.$index = i10;
            this.this$0 = stepData;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Argument [" + this.$index + "] is not a String. Source: " + this.this$0.getSrcJson();
        }
    }

    public StepData(@NotNull JSONObject srcJson, @NotNull Channel channel) {
        t.i(srcJson, "srcJson");
        t.i(channel, "channel");
        this.srcJson = srcJson;
        this.channel = channel;
        this.args$delegate = n.a(new StepData$args$2(this));
        this.firstArg$delegate = n.a(new StepData$firstArg$2(this));
        this.secondArg$delegate = n.a(new StepData$secondArg$2(this));
    }

    public static /* synthetic */ StepData copy$default(StepData stepData, JSONObject jSONObject, Channel channel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            jSONObject = stepData.srcJson;
        }
        if ((i10 & 2) != 0) {
            channel = stepData.channel;
        }
        return stepData.copy(jSONObject, channel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Object> getArgs() {
        return (List) this.args$delegate.getValue();
    }

    public static /* synthetic */ boolean isArgCountInBounds$default(StepData stepData, int i10, i iVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -1;
        }
        if ((i11 & 2) != 0) {
            iVar = null;
        }
        return stepData.isArgCountInBounds(i10, iVar);
    }

    @Nullable
    public final BrazeProperties coerceArgToPropertiesOrNull(int i10) {
        Object objL0 = d0.l0(getArgs(), i10);
        if (objL0 == null || !(objL0 instanceof JSONObject)) {
            return null;
        }
        return new BrazeProperties((JSONObject) objL0);
    }

    @NotNull
    public final StepData copy(@NotNull JSONObject srcJson, @NotNull Channel channel) {
        t.i(srcJson, "srcJson");
        t.i(channel, "channel");
        return new StepData(srcJson, channel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StepData)) {
            return false;
        }
        StepData stepData = (StepData) obj;
        return t.d(this.srcJson, stepData.srcJson) && this.channel == stepData.channel;
    }

    @VisibleForTesting
    @Nullable
    public final Object getArg$android_sdk_ui_release(int i10) {
        return d0.l0(getArgs(), i10);
    }

    @NotNull
    public final Channel getChannel() {
        return this.channel;
    }

    @Nullable
    public final Object getFirstArg() {
        return this.firstArg$delegate.getValue();
    }

    @Nullable
    public final Object getSecondArg() {
        return this.secondArg$delegate.getValue();
    }

    @NotNull
    public final JSONObject getSrcJson() {
        return this.srcJson;
    }

    public int hashCode() {
        return (this.srcJson.hashCode() * 31) + this.channel.hashCode();
    }

    public final boolean isArgCountInBounds(int i10, @Nullable i iVar) {
        if (i10 != -1 && getArgs().size() != i10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass1(i10, this), 7, (Object) null);
            return false;
        }
        if (iVar == null || iVar.i(getArgs().size())) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass2(iVar, this), 7, (Object) null);
        return false;
    }

    public final boolean isArgOptionalJsonObject(int i10) {
        Object arg$android_sdk_ui_release = getArg$android_sdk_ui_release(i10);
        if (arg$android_sdk_ui_release == null || (arg$android_sdk_ui_release instanceof JSONObject)) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C11491(i10, this), 7, (Object) null);
        return false;
    }

    public final boolean isArgString(int i10) {
        if (getArg$android_sdk_ui_release(i10) instanceof String) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C11501(i10, this), 7, (Object) null);
        return false;
    }

    @NotNull
    public String toString() {
        return "Channel " + this.channel + " and json\n" + JsonUtils.getPrettyPrintedString(this.srcJson);
    }

    public /* synthetic */ StepData(JSONObject jSONObject, Channel channel, int i10, k kVar) {
        this(jSONObject, (i10 & 2) != 0 ? Channel.UNKNOWN : channel);
    }
}
