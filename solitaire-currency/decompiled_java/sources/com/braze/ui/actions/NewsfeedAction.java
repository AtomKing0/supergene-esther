package com.braze.ui.actions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.braze.enums.Channel;
import com.braze.support.BrazeLogger;
import com.braze.ui.activities.BrazeFeedActivity;
import h9.a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NewsfeedAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public class NewsfeedAction implements IAction {

    @NotNull
    private final Channel channel;

    @Nullable
    private final Bundle extras;

    /* JADX INFO: renamed from: com.braze.ui.actions.NewsfeedAction$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: NewsfeedAction.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "BrazeFeedActivity was not opened successfully.";
        }
    }

    public NewsfeedAction(@Nullable Bundle bundle, @NotNull Channel channel) {
        t.i(channel, "channel");
        this.extras = bundle;
        this.channel = channel;
    }

    @Override // com.braze.ui.actions.IAction
    public void execute(@NotNull Context context) {
        t.i(context, "context");
        try {
            Intent intent = new Intent(context, (Class<?>) BrazeFeedActivity.class);
            Bundle bundle = this.extras;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            context.startActivity(intent);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) AnonymousClass1.INSTANCE, 4, (Object) null);
        }
    }
}
