package com.king.amp.sa;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.activision.Omid;
import com.iab.omid.library.activision.adsession.AdEvents;
import com.iab.omid.library.activision.adsession.AdSession;
import com.iab.omid.library.activision.adsession.AdSessionConfiguration;
import com.iab.omid.library.activision.adsession.AdSessionContext;
import com.iab.omid.library.activision.adsession.CreativeType;
import com.iab.omid.library.activision.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.activision.adsession.ImpressionType;
import com.iab.omid.library.activision.adsession.Owner;
import com.iab.omid.library.activision.adsession.Partner;
import com.iab.omid.library.activision.adsession.VerificationScriptResource;
import com.iab.omid.library.activision.adsession.media.MediaEvents;
import com.iab.omid.library.activision.adsession.media.Position;
import com.iab.omid.library.activision.adsession.media.VastProperties;
import com.king.amp.sa.o0;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: OmSdkWrapper.java */
/* JADX INFO: loaded from: classes4.dex */
public class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private AdSession f16892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private MediaEvents f16893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private AdEvents f16894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f16895d = f.UNKNOWN;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private e f16896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    o0 f16897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    private final Context f16898g;

    /* JADX INFO: compiled from: OmSdkWrapper.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f16900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f16901c;

        static {
            int[] iArr = new int[c.values().length];
            f16901c = iArr;
            try {
                iArr[c.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16901c[c.RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16901c[c.MUTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16901c[c.UNMUTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16901c[c.READY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16901c[c.COMPLETED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16901c[c.PROGRESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16901c[c.ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[f.values().length];
            f16900b = iArr2;
            try {
                iArr2[f.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16900b[f.FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f16900b[f.SECOND.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f16900b[f.THIRD.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f16900b[f.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr3 = new int[d.values().length];
            f16899a = iArr3;
            try {
                iArr3[d.VIDEO_CONTROLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f16899a[d.CLOSE_AD.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    /* JADX INFO: compiled from: OmSdkWrapper.java */
    public enum b {
        GENERIC,
        VIDEO;

        public static b c(int i10) {
            if (i10 == 0) {
                return GENERIC;
            }
            if (i10 != 1) {
                return null;
            }
            return VIDEO;
        }
    }

    /* JADX INFO: compiled from: OmSdkWrapper.java */
    public enum c {
        READY,
        COMPLETED,
        PROGRESS,
        PAUSE,
        RESUME,
        MUTE,
        UNMUTE,
        ERROR
    }

    /* JADX INFO: compiled from: OmSdkWrapper.java */
    public enum d {
        VIDEO_CONTROLS,
        CLOSE_AD,
        OTHER
    }

    /* JADX INFO: compiled from: OmSdkWrapper.java */
    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f16918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f16919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Float f16920c = null;

        e() {
        }
    }

    /* JADX INFO: compiled from: OmSdkWrapper.java */
    public enum f {
        UNKNOWN,
        START,
        FIRST,
        SECOND,
        THIRD
    }

    r1(@NonNull Context context) {
        this.f16898g = context;
        Omid.activate(context);
    }

    @Nullable
    private f c(long j10) {
        if (this.f16896e == null) {
            Log.w("OmSdkWrapper", "Playback config not initialized");
            return null;
        }
        double d10 = j10 / r0.f16919b;
        return l(d10, 0.0d) ? f.UNKNOWN : l(d10, 0.25d) ? f.START : l(d10, 0.5d) ? f.FIRST : l(d10, 0.75d) ? f.SECOND : f.THIRD;
    }

    private boolean d() {
        CreativeType creativeType;
        e eVar = this.f16896e;
        if (eVar == null || this.f16897f == null) {
            Log.w("OmSdkWrapper", "Playback config or ad verification not initialized");
            return false;
        }
        if (eVar.f16918a.equals("video")) {
            creativeType = CreativeType.VIDEO;
        } else {
            if (!this.f16896e.f16918a.equals("audio")) {
                Log.w("OmSdkWrapper", "Unsupported media type: " + this.f16896e.f16918a);
                return false;
            }
            creativeType = CreativeType.AUDIO;
        }
        Log.d("OmSdkWrapper", "Initializing for " + creativeType);
        ImpressionType impressionType = creativeType == CreativeType.AUDIO ? ImpressionType.AUDIBLE : ImpressionType.VIEWABLE;
        Owner owner = Owner.NATIVE;
        AdSessionConfiguration adSessionConfigurationCreateAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false);
        try {
            Partner partnerCreatePartner = Partner.createPartner(this.f16897f.b(), this.f16897f.c());
            List<VerificationScriptResource> listG = g();
            if (listG == null) {
                Log.w("OmSdkWrapper", "Failed to get verification scripts");
                return false;
            }
            String strF = f();
            if (strF == null) {
                Log.w("OmSdkWrapper", "Failed to get OM SDK JS");
                return false;
            }
            try {
                try {
                    this.f16892a = AdSession.createAdSession(adSessionConfigurationCreateAdSessionConfiguration, AdSessionContext.createNativeAdSessionContext(partnerCreatePartner, strF, listG, null, this.f16897f.a()));
                    return true;
                } catch (Exception e10) {
                    Log.w("OmSdkWrapper", "Failed to create ad session", e10);
                    return false;
                }
            } catch (Exception e11) {
                Log.w("OmSdkWrapper", "Failed to create ad session context", e11);
                return false;
            }
        } catch (IllegalArgumentException e12) {
            Log.w("OmSdkWrapper", "Failed to create partner", e12);
            return false;
        }
    }

    @Nullable
    private String f() {
        try {
            InputStream inputStreamOpenRawResource = this.f16898g.getResources().openRawResource(j6.h.f28753b);
            try {
                byte[] bArr = new byte[inputStreamOpenRawResource.available()];
                String str = new String(bArr, 0, inputStreamOpenRawResource.read(bArr), StandardCharsets.UTF_8);
                inputStreamOpenRawResource.close();
                return str;
            } finally {
            }
        } catch (Exception e10) {
            Log.w("OmSdkWrapper", "Unable to get Omid JS", e10);
            return null;
        }
    }

    @Nullable
    private List<VerificationScriptResource> g() {
        o0 o0Var = this.f16897f;
        if (o0Var == null) {
            Log.w("OmSdkWrapper", "Ad verification is null");
            return null;
        }
        List<o0.a> listD = o0Var.d();
        if (listD == null) {
            Log.w("OmSdkWrapper", "Verifications list is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (o0.a aVar : listD) {
            try {
                arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(aVar.f16840a, new URL(aVar.f16841b), aVar.f16842c));
            } catch (Exception e10) {
                Log.w("OmSdkWrapper", "Failed to create verification", e10);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private boolean h(c cVar) {
        if (this.f16893b == null) {
            Log.w("OmSdkWrapper", "Unable to handle action " + cVar + ", events not initialized");
            return false;
        }
        int i10 = a.f16901c[cVar.ordinal()];
        if (i10 == 1) {
            Log.d("OmSdkWrapper", "media::pause");
            try {
                this.f16893b.pause();
            } catch (Exception e10) {
                Log.w("OmSdkWrapper", "Failed to send pause", e10);
                return false;
            }
        } else if (i10 == 2) {
            Log.d("OmSdkWrapper", "media::resume");
            try {
                this.f16893b.resume();
            } catch (Exception e11) {
                Log.w("OmSdkWrapper", "Failed to send resume", e11);
                return false;
            }
        } else if (i10 == 3) {
            Log.d("OmSdkWrapper", "media::mute");
            try {
                this.f16893b.volumeChange(0.0f);
            } catch (Exception e12) {
                Log.w("OmSdkWrapper", "Failed to send mute", e12);
                return false;
            }
        } else {
            if (i10 != 4) {
                Log.w("OmSdkWrapper", "Unsupported event type: " + cVar);
                return false;
            }
            Log.d("OmSdkWrapper", "media::unmute");
            try {
                this.f16893b.volumeChange(1.0f);
            } catch (Exception e13) {
                Log.w("OmSdkWrapper", "Failed to send unmute", e13);
                return false;
            }
        }
        return true;
    }

    private boolean i(b bVar, @Nullable String str) {
        return false;
    }

    private boolean j(long j10) {
        if (j10 == 0) {
            Log.d("OmSdkWrapper", "Ignoring progress 0");
            return false;
        }
        f fVarC = c(j10);
        if (fVarC == this.f16895d || fVarC.ordinal() <= this.f16895d.ordinal()) {
            return false;
        }
        this.f16895d = fVarC;
        Log.i("OmSdkWrapper", "Quartile: " + fVarC + " at " + j10);
        return o(fVarC, j10);
    }

    private boolean l(double d10, double d11) {
        return d11 - d10 > 1.0E-6d;
    }

    private boolean m() {
        Log.i("OmSdkWrapper", "Playback is ended");
        if (this.f16893b == null) {
            Log.w("OmSdkWrapper", "Ad events are not initialized");
            return false;
        }
        try {
            Log.i("OmSdkWrapper", "media::complete");
            this.f16893b.complete();
            return true;
        } catch (Exception e10) {
            Log.w("OmSdkWrapper", "Failed to handle stop", e10);
            return false;
        }
    }

    private boolean n() {
        Log.d("OmSdkWrapper", "Playback is ready");
        if (this.f16894c == null) {
            Log.w("OmSdkWrapper", "Ad events not initialized");
            return false;
        }
        e eVar = this.f16896e;
        if (eVar == null) {
            Log.w("OmSdkWrapper", "Playback config not initialized");
            return false;
        }
        try {
            Float f10 = eVar.f16920c;
            VastProperties vastPropertiesCreateVastPropertiesForSkippableMedia = f10 != null ? VastProperties.createVastPropertiesForSkippableMedia(f10.floatValue(), false, Position.STANDALONE) : VastProperties.createVastPropertiesForNonSkippableMedia(false, Position.STANDALONE);
            Log.d("OmSdkWrapper", "event::loaded");
            this.f16894c.loaded(vastPropertiesCreateVastPropertiesForSkippableMedia);
            return true;
        } catch (Exception e10) {
            Log.w("OmSdkWrapper", "Failed to handle ready", e10);
            return false;
        }
    }

    private boolean o(f fVar, long j10) {
        if (this.f16893b == null) {
            Log.w("OmSdkWrapper", "Unable to send quartile, uninitialized media events");
            return false;
        }
        if (this.f16894c == null) {
            Log.w("OmSdkWrapper", "Unable to send quartile, uninitialized ad events");
            return false;
        }
        Log.d("OmSdkWrapper", "sendQuartile for " + fVar);
        int i10 = a.f16900b[fVar.ordinal()];
        if (i10 == 1) {
            try {
                Log.d("OmSdkWrapper", "media::start");
                this.f16893b.start(j10, 1.0f);
                Log.d("OmSdkWrapper", "event::impressionOccurred");
                this.f16894c.impressionOccurred();
            } catch (Exception e10) {
                Log.w("OmSdkWrapper", "Failed to handle start", e10);
                return false;
            }
        } else if (i10 == 2) {
            Log.d("OmSdkWrapper", "media::first");
            try {
                this.f16893b.firstQuartile();
            } catch (Exception e11) {
                Log.w("OmSdkWrapper", "Failed to handle 1Q", e11);
                return false;
            }
        } else if (i10 == 3) {
            Log.d("OmSdkWrapper", "media::midpoint");
            try {
                this.f16893b.midpoint();
            } catch (Exception e12) {
                Log.w("OmSdkWrapper", "Failed to handle 2Q", e12);
                return false;
            }
        } else if (i10 == 4) {
            Log.d("OmSdkWrapper", "media::third");
            try {
                this.f16893b.thirdQuartile();
            } catch (Exception e13) {
                Log.w("OmSdkWrapper", "Failed to handle 3Q", e13);
                return false;
            }
        } else if (i10 == 5) {
            return false;
        }
        return true;
    }

    public boolean a(c cVar, int i10, @Nullable String str) {
        if (this.f16893b == null) {
            Log.w("OmSdkWrapper", "Unable to handle event " + cVar + ", events not initialized");
            return false;
        }
        switch (a.f16901c[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                b bVarC = b.c(i10);
                if (bVarC == null || !i(bVarC, str)) {
                }
                break;
            default:
                Log.e("OmSdkWrapper", "Unsupported event type: " + cVar);
                break;
        }
        return false;
    }

    public boolean b(@NonNull View view, @NonNull d dVar, @NonNull String str) {
        if (this.f16892a == null) {
            Log.w("OmSdkWrapper", "Ad session is not initialized");
            return false;
        }
        int i10 = a.f16899a[dVar.ordinal()];
        try {
            this.f16892a.addFriendlyObstruction(view, i10 != 1 ? i10 != 2 ? FriendlyObstructionPurpose.OTHER : FriendlyObstructionPurpose.CLOSE_AD : FriendlyObstructionPurpose.VIDEO_CONTROLS, str);
            return true;
        } catch (Exception e10) {
            Log.w("OmSdkWrapper", "Failed to add friendly obstruction", e10);
            return false;
        }
    }

    public void e() {
        Log.d("OmSdkWrapper", "Finishing");
        AdSession adSession = this.f16892a;
        if (adSession != null) {
            adSession.removeAllFriendlyObstructions();
            this.f16892a.finish();
        }
        this.f16892a = null;
    }

    public boolean k(@NonNull e eVar, @Nullable o0 o0Var) {
        if (this.f16892a != null) {
            Log.w("OmSdkWrapper", "Ad session already initialized, will recreate it");
        }
        this.f16896e = eVar;
        this.f16897f = o0Var;
        return d();
    }

    public boolean p(View view) {
        Log.i("OmSdkWrapper", "Starting ad session");
        AdSession adSession = this.f16892a;
        if (adSession == null) {
            Log.w("OmSdkWrapper", "Ad session not initialized");
            return false;
        }
        this.f16893b = MediaEvents.createMediaEvents(adSession);
        this.f16894c = AdEvents.createAdEvents(this.f16892a);
        this.f16892a.registerAdView(view);
        this.f16892a.start();
        return true;
    }
}
