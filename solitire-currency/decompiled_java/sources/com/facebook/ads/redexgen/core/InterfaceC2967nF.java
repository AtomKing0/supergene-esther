package com.facebook.ads.redexgen.core;

import android.os.Looper;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC2967nF extends InterfaceC13422s, CX, ET, C9Q {

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Temporary Noop Implementation until we completely migrate")
    public static final InterfaceC2967nF A00 = new InterfaceC2967nF() { // from class: com.facebook.ads.redexgen.X.9S
        @Override // com.facebook.ads.redexgen.core.InterfaceC13422s
        public final /* synthetic */ void ACv(C3013o0 c3013o0) {
        }

        @Override // com.facebook.ads.redexgen.core.InterfaceC13422s
        public final /* synthetic */ void ACw(List list) {
        }

        @Override // com.facebook.ads.redexgen.core.CX
        public final /* synthetic */ void AD6(int i10, C2911mL c2911mL, CG cg) {
        }

        @Override // com.facebook.ads.redexgen.core.CX
        public final /* synthetic */ void ADw(int i10, C2911mL c2911mL, CE ce, CG cg) {
        }

        @Override // com.facebook.ads.redexgen.core.CX
        public final /* synthetic */ void ADy(int i10, C2911mL c2911mL, CE ce, CG cg, Object obj, Object obj2) {
        }

        @Override // com.facebook.ads.redexgen.core.CX
        public final /* synthetic */ void AE1(int i10, C2911mL c2911mL, CE ce, CG cg, IOException iOException, boolean z10) {
        }

        @Override // com.facebook.ads.redexgen.core.InterfaceC13422s
        public final /* synthetic */ void AEb(C3048ob c3048ob) {
        }

        @Override // com.facebook.ads.redexgen.core.InterfaceC13422s
        public final /* synthetic */ void AEd(C3050od c3050od) {
        }

        @Override // com.facebook.ads.redexgen.core.InterfaceC13422s
        public final /* synthetic */ void AEf(boolean z10, int i10) {
        }

        @Override // com.facebook.ads.redexgen.core.InterfaceC13422s
        public final /* synthetic */ void AFB() {
        }

        @Override // com.facebook.ads.redexgen.core.InterfaceC13422s
        public final /* synthetic */ void AFQ(Timeline timeline, int i10) {
            AbstractC13412r.A00(this, timeline, i10);
        }

        @Override // com.facebook.ads.redexgen.core.InterfaceC13422s
        public final /* synthetic */ void AFU(C3019o6 c3019o6) {
        }

        @Override // com.facebook.ads.redexgen.core.InterfaceC2967nF
        public final void AC5() {
        }

        @Override // com.facebook.ads.redexgen.core.InterfaceC2967nF
        public final void AIv(InterfaceC13492z interfaceC13492z, Looper looper) {
        }
    };

    void AC5();

    void AIv(InterfaceC13492z interfaceC13492z, Looper looper);
}
