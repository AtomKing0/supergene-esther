package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.CircularIntArray;
import io.sentry.protocol.SentryStackFrame;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
final class zzrw extends MediaCodec.Callback {
    private final HandlerThread zzb;
    private Handler zzc;

    @Nullable
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private MediaFormat zzh;

    @Nullable
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private MediaFormat zzi;

    @Nullable
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private MediaCodec.CodecException zzj;

    @Nullable
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private MediaCodec.CryptoException zzk;

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private long zzl;

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private boolean zzm;

    @Nullable
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private IllegalStateException zzn;

    @Nullable
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private zzsb zzo;
    private final Object zza = new Object();

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final CircularIntArray zzd = new CircularIntArray();

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final CircularIntArray zze = new CircularIntArray();

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final ArrayDeque zzf = new ArrayDeque();

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final ArrayDeque zzg = new ArrayDeque();

    zzrw(HandlerThread handlerThread) {
        this.zzb = handlerThread;
    }

    public static /* synthetic */ void zzd(zzrw zzrwVar) {
        synchronized (zzrwVar.zza) {
            if (zzrwVar.zzm) {
                return;
            }
            long j10 = zzrwVar.zzl - 1;
            zzrwVar.zzl = j10;
            if (j10 > 0) {
                return;
            }
            if (j10 >= 0) {
                zzrwVar.zzj();
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            synchronized (zzrwVar.zza) {
                zzrwVar.zzn = illegalStateException;
            }
        }
    }

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final void zzi(MediaFormat mediaFormat) {
        this.zze.addLast(-2);
        this.zzg.add(mediaFormat);
    }

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final void zzj() {
        if (!this.zzg.isEmpty()) {
            this.zzi = (MediaFormat) this.zzg.getLast();
        }
        this.zzd.clear();
        this.zze.clear();
        this.zzf.clear();
        this.zzg.clear();
    }

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final void zzk() {
        IllegalStateException illegalStateException = this.zzn;
        if (illegalStateException != null) {
            this.zzn = null;
            throw illegalStateException;
        }
        MediaCodec.CodecException codecException = this.zzj;
        if (codecException != null) {
            this.zzj = null;
            throw codecException;
        }
        MediaCodec.CryptoException cryptoException = this.zzk;
        if (cryptoException == null) {
            return;
        }
        this.zzk = null;
        throw cryptoException;
    }

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final boolean zzl() {
        return this.zzl > 0 || this.zzm;
    }

    @Override // android.media.MediaCodec.Callback
    public final void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.zza) {
            this.zzk = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.zza) {
            this.zzj = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i10) {
        synchronized (this.zza) {
            this.zzd.addLast(i10);
            zzsb zzsbVar = this.zzo;
            if (zzsbVar != null) {
                zzso zzsoVar = ((zzsm) zzsbVar).zza;
                if (zzsoVar.zzo != null) {
                    zzsoVar.zzo.zza();
                }
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i10, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            MediaFormat mediaFormat = this.zzi;
            if (mediaFormat != null) {
                zzi(mediaFormat);
                this.zzi = null;
            }
            this.zze.addLast(i10);
            this.zzf.add(bufferInfo);
            zzsb zzsbVar = this.zzo;
            if (zzsbVar != null) {
                zzso zzsoVar = ((zzsm) zzsbVar).zza;
                if (zzsoVar.zzo != null) {
                    zzsoVar.zzo.zza();
                }
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.zza) {
            zzi(mediaFormat);
            this.zzi = null;
        }
    }

    public final int zza() {
        synchronized (this.zza) {
            zzk();
            int iPopFirst = -1;
            if (zzl()) {
                return -1;
            }
            if (!this.zzd.isEmpty()) {
                iPopFirst = this.zzd.popFirst();
            }
            return iPopFirst;
        }
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            zzk();
            if (zzl()) {
                return -1;
            }
            if (this.zze.isEmpty()) {
                return -1;
            }
            int iPopFirst = this.zze.popFirst();
            if (iPopFirst >= 0) {
                zzdi.zzb(this.zzh);
                MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.zzf.remove();
                bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
            } else if (iPopFirst == -2) {
                this.zzh = (MediaFormat) this.zzg.remove();
                iPopFirst = -2;
            }
            return iPopFirst;
        }
    }

    public final MediaFormat zzc() {
        MediaFormat mediaFormat;
        synchronized (this.zza) {
            mediaFormat = this.zzh;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public final void zze() {
        synchronized (this.zza) {
            this.zzl++;
            Handler handler = this.zzc;
            int i10 = zzet.zza;
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrv
                @Override // java.lang.Runnable
                public final void run() {
                    zzrw.zzd(this.zza);
                }
            });
        }
    }

    public final void zzf(MediaCodec mediaCodec) {
        zzdi.zzf(this.zzc == null);
        this.zzb.start();
        Handler handler = new Handler(this.zzb.getLooper());
        mediaCodec.setCallback(this, handler);
        this.zzc = handler;
    }

    public final void zzg(zzsb zzsbVar) {
        synchronized (this.zza) {
            this.zzo = zzsbVar;
        }
    }

    public final void zzh() {
        synchronized (this.zza) {
            this.zzm = true;
            this.zzb.quit();
            zzj();
        }
    }
}
