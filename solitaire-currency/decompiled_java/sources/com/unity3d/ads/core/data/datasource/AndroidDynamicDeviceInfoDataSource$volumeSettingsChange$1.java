package com.unity3d.ads.core.data.datasource;

import android.database.ContentObserver;
import android.provider.Settings;
import com.unity3d.ads.core.data.datasource.VolumeSettingsChange;
import com.unity3d.mediation.LevelPlayAdError;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.j0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r9.j;
import r9.r;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: AndroidDynamicDeviceInfoDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1", f = "AndroidDynamicDeviceInfoDataSource.kt", l = {LevelPlayAdError.ERROR_CODE_IS_LOAD_FAILED_ALREADY_CALLED}, m = "invokeSuspend")
final class AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1 extends l implements p<r<? super VolumeSettingsChange>, d<? super k0>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidDynamicDeviceInfoDataSource this$0;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidDynamicDeviceInfoDataSource.kt */
    static final class AnonymousClass1 extends v implements h9.a<k0> {
        final /* synthetic */ AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1 $contentObserver;
        final /* synthetic */ AndroidDynamicDeviceInfoDataSource this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AndroidDynamicDeviceInfoDataSource androidDynamicDeviceInfoDataSource, AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1 androidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1) {
            super(0);
            this.this$0 = androidDynamicDeviceInfoDataSource;
            this.$contentObserver = androidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.getContext().getContentResolver().unregisterContentObserver(this.$contentObserver);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1(AndroidDynamicDeviceInfoDataSource androidDynamicDeviceInfoDataSource, d<? super AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1> dVar) {
        super(2, dVar);
        this.this$0 = androidDynamicDeviceInfoDataSource;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1 androidDynamicDeviceInfoDataSource$volumeSettingsChange$1 = new AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1(this.this$0, dVar);
        androidDynamicDeviceInfoDataSource$volumeSettingsChange$1.L$0 = obj;
        return androidDynamicDeviceInfoDataSource$volumeSettingsChange$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.database.ContentObserver, com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1] */
    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            final r rVar = (r) this.L$0;
            final j0 j0Var = new j0();
            double streamVolume = this.this$0.getStreamVolume(3);
            j0Var.f29828a = streamVolume;
            j.b(rVar, new VolumeSettingsChange.VolumeChange(streamVolume));
            final l0 l0Var = new l0();
            int ringerMode = this.this$0.getRingerMode();
            l0Var.f29831a = ringerMode;
            j.b(rVar, new VolumeSettingsChange.MuteChange(ringerMode == 0));
            final AndroidDynamicDeviceInfoDataSource androidDynamicDeviceInfoDataSource = this.this$0;
            ?? r42 = new ContentObserver() { // from class: com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(null);
                }

                @Override // android.database.ContentObserver
                public void onChange(boolean z10) {
                    super.onChange(z10);
                    double streamVolume2 = androidDynamicDeviceInfoDataSource.getStreamVolume(3);
                    j0 j0Var2 = j0Var;
                    if (!(streamVolume2 == j0Var2.f29828a)) {
                        j0Var2.f29828a = streamVolume2;
                        j.b(rVar, new VolumeSettingsChange.VolumeChange(streamVolume2));
                    }
                    int ringerMode2 = androidDynamicDeviceInfoDataSource.getRingerMode();
                    l0 l0Var2 = l0Var;
                    if (ringerMode2 != l0Var2.f29831a) {
                        l0Var2.f29831a = ringerMode2;
                        j.b(rVar, new VolumeSettingsChange.MuteChange(ringerMode2 == 0));
                    }
                }
            };
            this.this$0.getContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, r42);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, r42);
            this.label = 1;
            if (r9.p.a(rVar, anonymousClass1, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull r<? super VolumeSettingsChange> rVar, @Nullable d<? super k0> dVar) {
        return ((AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1) create(rVar, dVar)).invokeSuspend(k0.f35197a);
    }
}
