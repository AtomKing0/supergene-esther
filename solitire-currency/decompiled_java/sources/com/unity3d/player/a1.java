package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.MediaController;
import androidx.media3.common.PlaybackException;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class a1 extends FrameLayout implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, MediaController.MediaPlayerControl {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f24051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SurfaceView f24052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SurfaceHolder f24053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f24054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f24055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f24056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f24057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f24058h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f24059i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final a1 f24060j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f24061k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f24062l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f24063m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f24064n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private MediaPlayer f24065o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private MediaController f24066p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f24067q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f24068r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f24069s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f24070t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f24071u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f24072v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private C f24073w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Y0 f24074x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Z0 f24075y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile int f24076z;

    protected a1(Context context, UnityPlayer unityPlayer, String str, int i10, int i11, int i12, boolean z10, long j10, long j11, Y0 y02) {
        super(context);
        this.f24067q = false;
        this.f24068r = false;
        this.f24069s = 0;
        this.f24070t = false;
        this.f24071u = 0;
        this.f24072v = false;
        this.f24073w = null;
        this.f24076z = 0;
        this.f24074x = y02;
        this.f24051a = context;
        this.f24060j = this;
        SurfaceView surfaceView = new SurfaceView(context);
        this.f24052b = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.f24053c = holder;
        holder.addCallback(this);
        setBackgroundColor(i10);
        addView(surfaceView);
        this.f24054d = str;
        this.f24055e = i11;
        this.f24056f = i12;
        this.f24057g = z10;
        this.f24058h = j10;
        this.f24059i = j11;
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f24073w = D.a(unityPlayer.getActivity(), PlaybackException.CUSTOM_ERROR_CODE_BASE, new X0(this));
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return true;
    }

    public void cancelOnPrepare() {
        a(2);
    }

    protected void destroyPlayer() {
        if (!this.f24070t) {
            pause();
        }
        doCleanUp();
        C c10 = this.f24073w;
        if (c10 != null) {
            c10.unregisterOnBackPressedCallback();
            this.f24073w = null;
        }
    }

    protected void doCleanUp() {
        Z0 z02 = this.f24075y;
        if (z02 != null) {
            z02.f24049b = true;
            this.f24075y = null;
        }
        MediaPlayer mediaPlayer = this.f24065o;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f24065o.release();
            this.f24065o = null;
        }
        this.f24063m = 0;
        this.f24064n = 0;
        this.f24068r = false;
        this.f24067q = false;
    }

    public boolean exitOnKeypress(int i10, KeyEvent keyEvent) {
        Runnable runnable;
        if (i10 != 4 && (this.f24055e != 2 || i10 == 0 || keyEvent.isSystem())) {
            return false;
        }
        y6.c cVar = this.f24073w.f23918a;
        if ((cVar != null) && (runnable = ((B) cVar).f23916a) != null) {
            runnable.run();
        }
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        MediaPlayer mediaPlayer = this.f24065o;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getAudioSessionId();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.f24057g) {
            return this.f24069s;
        }
        return 100;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f24065o;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        MediaPlayer mediaPlayer = this.f24065o;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        boolean z10 = this.f24068r && this.f24067q;
        MediaPlayer mediaPlayer = this.f24065o;
        return mediaPlayer == null ? !z10 : mediaPlayer.isPlaying() || !z10;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
        this.f24069s = i10;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        destroyPlayer();
        a(3);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        MediaController mediaController = this.f24066p;
        return mediaController != null ? mediaController.onKeyDown(i10, keyEvent) : super.onKeyDown(i10, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (exitOnKeypress(i10, keyEvent)) {
            return true;
        }
        MediaController mediaController = this.f24066p;
        return mediaController != null ? mediaController.onKeyUp(i10, keyEvent) : super.onKeyUp(i10, keyEvent);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Z0 z02 = this.f24075y;
        if (z02 != null) {
            z02.f24049b = true;
            this.f24075y = null;
        }
        int i10 = this.f24055e;
        if (i10 == 0 || i10 == 1) {
            MediaController mediaController = new MediaController(this.f24051a);
            this.f24066p = mediaController;
            mediaController.setMediaPlayer(this);
            this.f24066p.setAnchorView(this);
            this.f24066p.setEnabled(true);
            Context context = this.f24051a;
            if (context instanceof Activity) {
                this.f24066p.setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility());
            }
            this.f24066p.show();
        }
        this.f24068r = true;
        if (!this.f24067q || isPlaying()) {
            return;
        }
        a(1);
        updateVideoLayout();
        if (this.f24070t) {
            return;
        }
        start();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f24055e != 2 || action != 0) {
            MediaController mediaController = this.f24066p;
            return mediaController != null ? mediaController.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
        }
        destroyPlayer();
        a(3);
        return true;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return;
        }
        this.f24067q = true;
        this.f24063m = i10;
        this.f24064n = i11;
        if (!this.f24068r || isPlaying()) {
            return;
        }
        a(1);
        updateVideoLayout();
        if (this.f24070t) {
            return;
        }
        start();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        MediaPlayer mediaPlayer = this.f24065o;
        if (mediaPlayer == null) {
            return;
        }
        if (this.f24072v) {
            this.f24071u = mediaPlayer.getCurrentPosition();
            this.f24065o.pause();
        }
        this.f24070t = true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i10) {
        MediaPlayer mediaPlayer = this.f24065o;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.seekTo(i10);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        MediaPlayer mediaPlayer = this.f24065o;
        if (mediaPlayer == null) {
            return;
        }
        if (this.f24072v) {
            int i10 = this.f24071u;
            if (i10 > 0) {
                mediaPlayer.seekTo(i10);
            }
            this.f24065o.start();
            this.f24071u = 0;
        }
        this.f24070t = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        if (this.f24061k == i11 && this.f24062l == i12) {
            return;
        }
        this.f24061k = i11;
        this.f24062l = i12;
        if (this.f24072v) {
            updateVideoLayout();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        FileInputStream fileInputStream;
        this.f24072v = true;
        if (this.f24070t) {
            MediaPlayer mediaPlayer = this.f24065o;
            if (mediaPlayer == null || this.f24071u <= 0) {
                return;
            }
            mediaPlayer.setDisplay(this.f24053c);
            this.f24065o.seekTo(this.f24071u);
            return;
        }
        MediaPlayer mediaPlayer2 = this.f24065o;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setDisplay(this.f24053c);
            if (this.f24070t) {
                return;
            }
            int i10 = this.f24071u;
            if (i10 > 0) {
                this.f24065o.seekTo(i10);
            }
            this.f24065o.start();
            this.f24071u = 0;
            return;
        }
        a(0);
        doCleanUp();
        try {
            MediaPlayer mediaPlayer3 = new MediaPlayer();
            this.f24065o = mediaPlayer3;
            if (this.f24057g) {
                mediaPlayer3.setDataSource(this.f24051a, Uri.parse(this.f24054d));
            } else {
                if (this.f24059i != 0) {
                    fileInputStream = new FileInputStream(this.f24054d);
                    this.f24065o.setDataSource(fileInputStream.getFD(), this.f24058h, this.f24059i);
                } else {
                    try {
                        AssetFileDescriptor assetFileDescriptorOpenFd = getResources().getAssets().openFd(this.f24054d);
                        this.f24065o.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                        assetFileDescriptorOpenFd.close();
                    } catch (IOException unused) {
                        fileInputStream = new FileInputStream(this.f24054d);
                        this.f24065o.setDataSource(fileInputStream.getFD());
                        fileInputStream.close();
                    }
                }
                fileInputStream.close();
            }
            this.f24065o.setDisplay(this.f24053c);
            this.f24065o.setScreenOnWhilePlaying(true);
            this.f24065o.setOnBufferingUpdateListener(this);
            this.f24065o.setOnCompletionListener(this);
            this.f24065o.setOnPreparedListener(this);
            this.f24065o.setOnVideoSizeChangedListener(this);
            this.f24065o.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build());
            this.f24065o.prepareAsync();
            this.f24075y = new Z0(this);
            new Thread(this.f24075y).start();
        } catch (Exception unused2) {
            a(2);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f24072v = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        if (r7 <= r3) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        if (r7 >= r3) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        r4 = (int) (r5 / r3);
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        r2 = (int) (r6 * r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
    
        if (r8 == 0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void updateVideoLayout() {
        /*
            r10 = this;
            android.media.MediaPlayer r0 = r10.f24065o
            if (r0 != 0) goto L5
            return
        L5:
            android.content.Context r0 = r10.f24051a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.util.DisplayMetrics r1 = new android.util.DisplayMetrics
            r1.<init>()
            android.view.Display r0 = r0.getDefaultDisplay()
            r0.getMetrics(r1)
            int r0 = r1.widthPixels
            if (r0 <= 0) goto L27
            int r1 = r1.heightPixels
            if (r1 <= 0) goto L27
            r10.f24061k = r0
            r10.f24062l = r1
        L27:
            int r0 = r10.f24061k
            int r1 = r10.f24062l
            boolean r2 = r10.f24067q
            if (r2 == 0) goto L55
            int r2 = r10.f24063m
            float r3 = (float) r2
            int r4 = r10.f24064n
            float r5 = (float) r4
            float r3 = r3 / r5
            float r5 = (float) r0
            float r6 = (float) r1
            float r7 = r5 / r6
            int r8 = r10.f24056f
            r9 = 1
            if (r8 != r9) goto L44
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 > 0) goto L4f
            goto L4b
        L44:
            r9 = 2
            if (r8 != r9) goto L52
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 < 0) goto L4f
        L4b:
            float r5 = r5 / r3
            int r4 = (int) r5
            r2 = r0
            goto L57
        L4f:
            float r6 = r6 * r3
            int r2 = (int) r6
            goto L56
        L52:
            if (r8 != 0) goto L55
            goto L57
        L55:
            r2 = r0
        L56:
            r4 = r1
        L57:
            if (r0 != r2) goto L5b
            if (r1 == r4) goto L69
        L5b:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = 17
            r0.<init>(r2, r4, r1)
            com.unity3d.player.a1 r1 = r10.f24060j
            android.view.SurfaceView r2 = r10.f24052b
            r1.updateViewLayout(r2, r0)
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.a1.updateVideoLayout():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10) {
        this.f24076z = i10;
        Y0 y02 = this.f24074x;
        if (y02 != null) {
            ((c1) y02).a(this.f24076z);
        }
    }

    final boolean a() {
        return this.f24070t;
    }
}
