package androidx.media3.exoplayer.analytics;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.PlaybackSessionManager;
import androidx.media3.exoplayer.source.MediaSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class DefaultPlaybackSessionManager implements PlaybackSessionManager {
    public static final e5.u<String> DEFAULT_SESSION_ID_GENERATOR = new e5.u() { // from class: androidx.media3.exoplayer.analytics.u1
        @Override // e5.u
        public final Object get() {
            return DefaultPlaybackSessionManager.generateDefaultSessionId();
        }
    };
    private static final Random RANDOM = new Random();
    private static final int SESSION_ID_LENGTH = 12;

    @Nullable
    private String currentSessionId;
    private Timeline currentTimeline;
    private long lastRemovedCurrentWindowSequenceNumber;
    private PlaybackSessionManager.Listener listener;
    private final Timeline.Period period;
    private final e5.u<String> sessionIdGenerator;
    private final HashMap<String, SessionDescriptor> sessions;
    private final Timeline.Window window;

    private final class SessionDescriptor {
        private MediaSource.MediaPeriodId adMediaPeriodId;
        private boolean isActive;
        private boolean isCreated;
        private final String sessionId;
        private int windowIndex;
        private long windowSequenceNumber;

        public SessionDescriptor(String str, int i10, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            this.sessionId = str;
            this.windowIndex = i10;
            this.windowSequenceNumber = mediaPeriodId == null ? -1L : mediaPeriodId.windowSequenceNumber;
            if (mediaPeriodId == null || !mediaPeriodId.isAd()) {
                return;
            }
            this.adMediaPeriodId = mediaPeriodId;
        }

        private int resolveWindowIndexToNewTimeline(Timeline timeline, Timeline timeline2, int i10) {
            if (i10 >= timeline.getWindowCount()) {
                if (i10 < timeline2.getWindowCount()) {
                    return i10;
                }
                return -1;
            }
            timeline.getWindow(i10, DefaultPlaybackSessionManager.this.window);
            for (int i11 = DefaultPlaybackSessionManager.this.window.firstPeriodIndex; i11 <= DefaultPlaybackSessionManager.this.window.lastPeriodIndex; i11++) {
                int indexOfPeriod = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(i11));
                if (indexOfPeriod != -1) {
                    return timeline2.getPeriod(indexOfPeriod, DefaultPlaybackSessionManager.this.period).windowIndex;
                }
            }
            return -1;
        }

        public boolean belongsToSession(int i10, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (mediaPeriodId == null) {
                return i10 == this.windowIndex;
            }
            MediaSource.MediaPeriodId mediaPeriodId2 = this.adMediaPeriodId;
            return mediaPeriodId2 == null ? !mediaPeriodId.isAd() && mediaPeriodId.windowSequenceNumber == this.windowSequenceNumber : mediaPeriodId.windowSequenceNumber == mediaPeriodId2.windowSequenceNumber && mediaPeriodId.adGroupIndex == mediaPeriodId2.adGroupIndex && mediaPeriodId.adIndexInAdGroup == mediaPeriodId2.adIndexInAdGroup;
        }

        public boolean isFinishedAtEventTime(AnalyticsListener.EventTime eventTime) {
            MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
            if (mediaPeriodId == null) {
                return this.windowIndex != eventTime.windowIndex;
            }
            long j10 = this.windowSequenceNumber;
            if (j10 == -1) {
                return false;
            }
            if (mediaPeriodId.windowSequenceNumber > j10) {
                return true;
            }
            if (this.adMediaPeriodId == null) {
                return false;
            }
            int indexOfPeriod = eventTime.timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
            int indexOfPeriod2 = eventTime.timeline.getIndexOfPeriod(this.adMediaPeriodId.periodUid);
            MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.mediaPeriodId;
            if (mediaPeriodId2.windowSequenceNumber < this.adMediaPeriodId.windowSequenceNumber || indexOfPeriod < indexOfPeriod2) {
                return false;
            }
            if (indexOfPeriod > indexOfPeriod2) {
                return true;
            }
            if (!mediaPeriodId2.isAd()) {
                int i10 = eventTime.mediaPeriodId.nextAdGroupIndex;
                return i10 == -1 || i10 > this.adMediaPeriodId.adGroupIndex;
            }
            MediaSource.MediaPeriodId mediaPeriodId3 = eventTime.mediaPeriodId;
            int i11 = mediaPeriodId3.adGroupIndex;
            int i12 = mediaPeriodId3.adIndexInAdGroup;
            MediaSource.MediaPeriodId mediaPeriodId4 = this.adMediaPeriodId;
            int i13 = mediaPeriodId4.adGroupIndex;
            if (i11 <= i13) {
                return i11 == i13 && i12 > mediaPeriodId4.adIndexInAdGroup;
            }
            return true;
        }

        public void maybeSetWindowSequenceNumber(int i10, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.windowSequenceNumber != -1 || i10 != this.windowIndex || mediaPeriodId == null || mediaPeriodId.windowSequenceNumber < DefaultPlaybackSessionManager.this.getMinWindowSequenceNumber()) {
                return;
            }
            this.windowSequenceNumber = mediaPeriodId.windowSequenceNumber;
        }

        public boolean tryResolvingToNewTimeline(Timeline timeline, Timeline timeline2) {
            int iResolveWindowIndexToNewTimeline = resolveWindowIndexToNewTimeline(timeline, timeline2, this.windowIndex);
            this.windowIndex = iResolveWindowIndexToNewTimeline;
            if (iResolveWindowIndexToNewTimeline == -1) {
                return false;
            }
            MediaSource.MediaPeriodId mediaPeriodId = this.adMediaPeriodId;
            return mediaPeriodId == null || timeline2.getIndexOfPeriod(mediaPeriodId.periodUid) != -1;
        }
    }

    public DefaultPlaybackSessionManager() {
        this(DEFAULT_SESSION_ID_GENERATOR);
    }

    private void clearCurrentSession(SessionDescriptor sessionDescriptor) {
        if (sessionDescriptor.windowSequenceNumber != -1) {
            this.lastRemovedCurrentWindowSequenceNumber = sessionDescriptor.windowSequenceNumber;
        }
        this.currentSessionId = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateDefaultSessionId() {
        byte[] bArr = new byte[12];
        RANDOM.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getMinWindowSequenceNumber() {
        SessionDescriptor sessionDescriptor = this.sessions.get(this.currentSessionId);
        return (sessionDescriptor == null || sessionDescriptor.windowSequenceNumber == -1) ? this.lastRemovedCurrentWindowSequenceNumber + 1 : sessionDescriptor.windowSequenceNumber;
    }

    private SessionDescriptor getOrAddSession(int i10, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        SessionDescriptor sessionDescriptor = null;
        long j10 = Long.MAX_VALUE;
        for (SessionDescriptor sessionDescriptor2 : this.sessions.values()) {
            sessionDescriptor2.maybeSetWindowSequenceNumber(i10, mediaPeriodId);
            if (sessionDescriptor2.belongsToSession(i10, mediaPeriodId)) {
                long j11 = sessionDescriptor2.windowSequenceNumber;
                if (j11 == -1 || j11 < j10) {
                    sessionDescriptor = sessionDescriptor2;
                    j10 = j11;
                } else if (j11 == j10 && ((SessionDescriptor) Util.castNonNull(sessionDescriptor)).adMediaPeriodId != null && sessionDescriptor2.adMediaPeriodId != null) {
                    sessionDescriptor = sessionDescriptor2;
                }
            }
        }
        if (sessionDescriptor != null) {
            return sessionDescriptor;
        }
        String str = this.sessionIdGenerator.get();
        SessionDescriptor sessionDescriptor3 = new SessionDescriptor(str, i10, mediaPeriodId);
        this.sessions.put(str, sessionDescriptor3);
        return sessionDescriptor3;
    }

    private void updateCurrentSession(AnalyticsListener.EventTime eventTime) {
        if (eventTime.timeline.isEmpty()) {
            String str = this.currentSessionId;
            if (str != null) {
                clearCurrentSession((SessionDescriptor) Assertions.checkNotNull(this.sessions.get(str)));
                return;
            }
            return;
        }
        SessionDescriptor sessionDescriptor = this.sessions.get(this.currentSessionId);
        SessionDescriptor orAddSession = getOrAddSession(eventTime.windowIndex, eventTime.mediaPeriodId);
        this.currentSessionId = orAddSession.sessionId;
        updateSessions(eventTime);
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (mediaPeriodId == null || !mediaPeriodId.isAd()) {
            return;
        }
        if (sessionDescriptor != null && sessionDescriptor.windowSequenceNumber == eventTime.mediaPeriodId.windowSequenceNumber && sessionDescriptor.adMediaPeriodId != null && sessionDescriptor.adMediaPeriodId.adGroupIndex == eventTime.mediaPeriodId.adGroupIndex && sessionDescriptor.adMediaPeriodId.adIndexInAdGroup == eventTime.mediaPeriodId.adIndexInAdGroup) {
            return;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.mediaPeriodId;
        this.listener.onAdPlaybackStarted(eventTime, getOrAddSession(eventTime.windowIndex, new MediaSource.MediaPeriodId(mediaPeriodId2.periodUid, mediaPeriodId2.windowSequenceNumber)).sessionId, orAddSession.sessionId);
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    public synchronized boolean belongsToSession(AnalyticsListener.EventTime eventTime, String str) {
        SessionDescriptor sessionDescriptor = this.sessions.get(str);
        if (sessionDescriptor == null) {
            return false;
        }
        sessionDescriptor.maybeSetWindowSequenceNumber(eventTime.windowIndex, eventTime.mediaPeriodId);
        return sessionDescriptor.belongsToSession(eventTime.windowIndex, eventTime.mediaPeriodId);
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    public synchronized void finishAllSessions(AnalyticsListener.EventTime eventTime) {
        PlaybackSessionManager.Listener listener;
        String str = this.currentSessionId;
        if (str != null) {
            clearCurrentSession((SessionDescriptor) Assertions.checkNotNull(this.sessions.get(str)));
        }
        Iterator<SessionDescriptor> it = this.sessions.values().iterator();
        while (it.hasNext()) {
            SessionDescriptor next = it.next();
            it.remove();
            if (next.isCreated && (listener = this.listener) != null) {
                listener.onSessionFinished(eventTime, next.sessionId, false);
            }
        }
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    @Nullable
    public synchronized String getActiveSessionId() {
        return this.currentSessionId;
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    public synchronized String getSessionForMediaPeriodId(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        return getOrAddSession(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, mediaPeriodId).sessionId;
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    public void setListener(PlaybackSessionManager.Listener listener) {
        this.listener = listener;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00db A[Catch: all -> 0x0112, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0018, B:15:0x0024, B:17:0x0030, B:19:0x003a, B:23:0x0044, B:25:0x0050, B:26:0x0056, B:28:0x005b, B:30:0x0061, B:32:0x007a, B:34:0x00d5, B:36:0x00db, B:38:0x00f1, B:40:0x00fd, B:42:0x0103), top: B:48:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ed  */
    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void updateSessions(androidx.media3.exoplayer.analytics.AnalyticsListener.EventTime r25) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager.updateSessions(androidx.media3.exoplayer.analytics.AnalyticsListener$EventTime):void");
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    public synchronized void updateSessionsWithDiscontinuity(AnalyticsListener.EventTime eventTime, int i10) {
        Assertions.checkNotNull(this.listener);
        boolean z10 = i10 == 0;
        Iterator<SessionDescriptor> it = this.sessions.values().iterator();
        while (it.hasNext()) {
            SessionDescriptor next = it.next();
            if (next.isFinishedAtEventTime(eventTime)) {
                it.remove();
                if (next.isCreated) {
                    boolean zEquals = next.sessionId.equals(this.currentSessionId);
                    boolean z11 = z10 && zEquals && next.isActive;
                    if (zEquals) {
                        clearCurrentSession(next);
                    }
                    this.listener.onSessionFinished(eventTime, next.sessionId, z11);
                }
            }
        }
        updateCurrentSession(eventTime);
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    public synchronized void updateSessionsWithTimelineChange(AnalyticsListener.EventTime eventTime) {
        Assertions.checkNotNull(this.listener);
        Timeline timeline = this.currentTimeline;
        this.currentTimeline = eventTime.timeline;
        Iterator<SessionDescriptor> it = this.sessions.values().iterator();
        while (it.hasNext()) {
            SessionDescriptor next = it.next();
            if (!next.tryResolvingToNewTimeline(timeline, this.currentTimeline) || next.isFinishedAtEventTime(eventTime)) {
                it.remove();
                if (next.isCreated) {
                    if (next.sessionId.equals(this.currentSessionId)) {
                        clearCurrentSession(next);
                    }
                    this.listener.onSessionFinished(eventTime, next.sessionId, false);
                }
            }
        }
        updateCurrentSession(eventTime);
    }

    public DefaultPlaybackSessionManager(e5.u<String> uVar) {
        this.sessionIdGenerator = uVar;
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.sessions = new HashMap<>();
        this.currentTimeline = Timeline.EMPTY;
        this.lastRemovedCurrentWindowSequenceNumber = -1L;
    }
}
