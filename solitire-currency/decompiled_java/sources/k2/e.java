package k2;

import androidx.media3.common.C;
import java.util.List;
import k2.n3;

/* JADX INFO: compiled from: BasePlayer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e implements r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final n3.d f29076a = new n3.d();

    protected e() {
    }

    private int j() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    private void o(long j10) {
        long currentPosition = getCurrentPosition() + j10;
        long duration = getDuration();
        if (duration != C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekTo(Math.max(currentPosition, 0L));
    }

    @Override // k2.r2
    public final void d(w1 w1Var) {
        q(com.google.common.collect.y.r(w1Var));
    }

    public final long g() {
        n3 currentTimeline = getCurrentTimeline();
        return currentTimeline.u() ? C.TIME_UNSET : currentTimeline.r(getCurrentMediaItemIndex(), this.f29076a).g();
    }

    public final int h() {
        n3 currentTimeline = getCurrentTimeline();
        if (currentTimeline.u()) {
            return -1;
        }
        return currentTimeline.i(getCurrentMediaItemIndex(), j(), getShuffleModeEnabled());
    }

    @Override // k2.r2
    public final boolean hasNextMediaItem() {
        return h() != -1;
    }

    @Override // k2.r2
    public final boolean hasPreviousMediaItem() {
        return i() != -1;
    }

    public final int i() {
        n3 currentTimeline = getCurrentTimeline();
        if (currentTimeline.u()) {
            return -1;
        }
        return currentTimeline.p(getCurrentMediaItemIndex(), j(), getShuffleModeEnabled());
    }

    @Override // k2.r2
    public final boolean isCommandAvailable(int i10) {
        return getAvailableCommands().c(i10);
    }

    @Override // k2.r2
    public final boolean isCurrentMediaItemDynamic() {
        n3 currentTimeline = getCurrentTimeline();
        return !currentTimeline.u() && currentTimeline.r(getCurrentMediaItemIndex(), this.f29076a).f29321i;
    }

    @Override // k2.r2
    public final boolean isCurrentMediaItemLive() {
        n3 currentTimeline = getCurrentTimeline();
        return !currentTimeline.u() && currentTimeline.r(getCurrentMediaItemIndex(), this.f29076a).i();
    }

    @Override // k2.r2
    public final boolean isCurrentMediaItemSeekable() {
        n3 currentTimeline = getCurrentTimeline();
        return !currentTimeline.u() && currentTimeline.r(getCurrentMediaItemIndex(), this.f29076a).f29320h;
    }

    @Override // k2.r2
    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    protected abstract void k();

    public final void l() {
        m(getCurrentMediaItemIndex());
    }

    public final void m(int i10) {
        seekTo(i10, C.TIME_UNSET);
    }

    public final void n() {
        int iH = h();
        if (iH == -1) {
            return;
        }
        if (iH == getCurrentMediaItemIndex()) {
            k();
        } else {
            m(iH);
        }
    }

    public final void p() {
        int i10 = i();
        if (i10 == -1) {
            return;
        }
        if (i10 == getCurrentMediaItemIndex()) {
            k();
        } else {
            m(i10);
        }
    }

    @Override // k2.r2
    public final void pause() {
        setPlayWhenReady(false);
    }

    @Override // k2.r2
    public final void play() {
        setPlayWhenReady(true);
    }

    public final void q(List<w1> list) {
        setMediaItems(list, true);
    }

    @Override // k2.r2
    public final void seekBack() {
        o(-getSeekBackIncrement());
    }

    @Override // k2.r2
    public final void seekForward() {
        o(getSeekForwardIncrement());
    }

    @Override // k2.r2
    public final void seekTo(long j10) {
        seekTo(getCurrentMediaItemIndex(), j10);
    }

    @Override // k2.r2
    public final void seekToNext() {
        if (getCurrentTimeline().u() || isPlayingAd()) {
            return;
        }
        if (hasNextMediaItem()) {
            n();
        } else if (isCurrentMediaItemLive() && isCurrentMediaItemDynamic()) {
            l();
        }
    }

    @Override // k2.r2
    public final void seekToPrevious() {
        if (getCurrentTimeline().u() || isPlayingAd()) {
            return;
        }
        boolean zHasPreviousMediaItem = hasPreviousMediaItem();
        if (isCurrentMediaItemLive() && !isCurrentMediaItemSeekable()) {
            if (zHasPreviousMediaItem) {
                p();
            }
        } else if (!zHasPreviousMediaItem || getCurrentPosition() > getMaxSeekToPreviousPosition()) {
            seekTo(0L);
        } else {
            p();
        }
    }
}
