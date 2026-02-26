package androidx.media3.exoplayer.dash;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.dash.DashChunkSource;
import androidx.media3.exoplayer.dash.PlayerEmsgHandler;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.Descriptor;
import androidx.media3.exoplayer.dash.manifest.EventStream;
import androidx.media3.exoplayer.dash.manifest.Period;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.CompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.EmptySampleStream;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.chunk.ChunkSampleStream;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import com.google.common.collect.j0;
import com.google.common.collect.k0;
import com.google.common.collect.y;
import e5.g;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
final class DashMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>>, ChunkSampleStream.ReleaseCallback<DashChunkSource> {
    private static final Pattern CEA608_SERVICE_DESCRIPTOR_REGEX = Pattern.compile("CC([1-4])=(.+)");
    private static final Pattern CEA708_SERVICE_DESCRIPTOR_REGEX = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    private final Allocator allocator;
    private final BaseUrlExclusionList baseUrlExclusionList;

    @Nullable
    private MediaPeriod.Callback callback;
    private final DashChunkSource.Factory chunkSourceFactory;

    @Nullable
    private final CmcdConfiguration cmcdConfiguration;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private final long elapsedRealtimeOffsetMs;
    private List<EventStream> eventStreams;
    final int id;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final MediaSourceEventListener.EventDispatcher mediaSourceEventDispatcher;
    private int periodIndex;
    private final PlayerEmsgHandler playerEmsgHandler;
    private final PlayerId playerId;
    private final TrackGroupInfo[] trackGroupInfos;
    private final TrackGroupArray trackGroups;

    @Nullable
    private final TransferListener transferListener;
    private ChunkSampleStream<DashChunkSource>[] sampleStreams = newSampleStreamArray(0);
    private EventSampleStream[] eventSampleStreams = new EventSampleStream[0];
    private final IdentityHashMap<ChunkSampleStream<DashChunkSource>, PlayerEmsgHandler.PlayerTrackEmsgHandler> trackEmsgHandlerBySampleStream = new IdentityHashMap<>();

    private static final class TrackGroupInfo {
        private static final int CATEGORY_EMBEDDED = 1;
        private static final int CATEGORY_MANIFEST_EVENTS = 2;
        private static final int CATEGORY_PRIMARY = 0;
        public final int[] adaptationSetIndices;
        public final int embeddedClosedCaptionTrackGroupIndex;
        public final y<Format> embeddedClosedCaptionTrackOriginalFormats;
        public final int embeddedEventMessageTrackGroupIndex;
        public final int eventStreamGroupIndex;
        public final int primaryTrackGroupIndex;
        public final int trackGroupCategory;
        public final int trackType;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface TrackGroupCategory {
        }

        private TrackGroupInfo(int i10, int i11, int[] iArr, int i12, int i13, int i14, int i15, y<Format> yVar) {
            this.trackType = i10;
            this.adaptationSetIndices = iArr;
            this.trackGroupCategory = i11;
            this.primaryTrackGroupIndex = i12;
            this.embeddedEventMessageTrackGroupIndex = i13;
            this.embeddedClosedCaptionTrackGroupIndex = i14;
            this.eventStreamGroupIndex = i15;
            this.embeddedClosedCaptionTrackOriginalFormats = yVar;
        }

        public static TrackGroupInfo embeddedClosedCaptionTrack(int[] iArr, int i10, y<Format> yVar) {
            return new TrackGroupInfo(3, 1, iArr, i10, -1, -1, -1, yVar);
        }

        public static TrackGroupInfo embeddedEmsgTrack(int[] iArr, int i10) {
            return new TrackGroupInfo(5, 1, iArr, i10, -1, -1, -1, y.q());
        }

        public static TrackGroupInfo mpdEventTrack(int i10) {
            return new TrackGroupInfo(5, 2, new int[0], -1, -1, -1, i10, y.q());
        }

        public static TrackGroupInfo primaryTrack(int i10, int[] iArr, int i11, int i12, int i13) {
            return new TrackGroupInfo(i10, 0, iArr, i11, i12, i13, -1, y.q());
        }
    }

    public DashMediaPeriod(int i10, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i11, DashChunkSource.Factory factory, @Nullable TransferListener transferListener, @Nullable CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, long j10, LoaderErrorThrower loaderErrorThrower, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback, PlayerId playerId) {
        this.id = i10;
        this.manifest = dashManifest;
        this.baseUrlExclusionList = baseUrlExclusionList;
        this.periodIndex = i11;
        this.chunkSourceFactory = factory;
        this.transferListener = transferListener;
        this.cmcdConfiguration = cmcdConfiguration;
        this.drmSessionManager = drmSessionManager;
        this.drmEventDispatcher = eventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.mediaSourceEventDispatcher = eventDispatcher2;
        this.elapsedRealtimeOffsetMs = j10;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.allocator = allocator;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.playerId = playerId;
        this.playerEmsgHandler = new PlayerEmsgHandler(dashManifest, playerEmsgCallback, allocator);
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory.empty();
        Period period = dashManifest.getPeriod(i11);
        List<EventStream> list = period.eventStreams;
        this.eventStreams = list;
        Pair<TrackGroupArray, TrackGroupInfo[]> pairBuildTrackGroups = buildTrackGroups(drmSessionManager, factory, period.adaptationSets, list);
        this.trackGroups = (TrackGroupArray) pairBuildTrackGroups.first;
        this.trackGroupInfos = (TrackGroupInfo[]) pairBuildTrackGroups.second;
    }

    private static void buildManifestEventTrackGroupInfos(List<EventStream> list, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr, int i10) {
        int i11 = 0;
        while (i11 < list.size()) {
            EventStream eventStream = list.get(i11);
            trackGroupArr[i10] = new TrackGroup(eventStream.id() + ":" + i11, new Format.Builder().setId(eventStream.id()).setSampleMimeType(MimeTypes.APPLICATION_EMSG).build());
            trackGroupInfoArr[i10] = TrackGroupInfo.mpdEventTrack(i11);
            i11++;
            i10++;
        }
    }

    private static int buildPrimaryAndEmbeddedTrackGroupInfos(DrmSessionManager drmSessionManager, DashChunkSource.Factory factory, List<AdaptationSet> list, int[][] iArr, int i10, boolean[] zArr, Format[][] formatArr, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr) {
        int i11;
        int i12;
        int i13;
        int i14 = 0;
        int i15 = 0;
        while (i14 < i10) {
            int[] iArr2 = iArr[i14];
            ArrayList arrayList = new ArrayList();
            for (int i16 : iArr2) {
                arrayList.addAll(list.get(i16).representations);
            }
            int size = arrayList.size();
            Format[] formatArr2 = new Format[size];
            for (int i17 = 0; i17 < size; i17++) {
                Format format = ((Representation) arrayList.get(i17)).format;
                formatArr2[i17] = format.buildUpon().setCryptoType(drmSessionManager.getCryptoType(format)).build();
            }
            AdaptationSet adaptationSet = list.get(iArr2[0]);
            long j10 = adaptationSet.id;
            String string = j10 != -1 ? Long.toString(j10) : "unset:" + i14;
            int i18 = i15 + 1;
            if (zArr[i14]) {
                i11 = i18 + 1;
            } else {
                i11 = i18;
                i18 = -1;
            }
            if (formatArr[i14].length != 0) {
                i12 = i11 + 1;
            } else {
                i12 = i11;
                i11 = -1;
            }
            maybeUpdateFormatsForParsedText(factory, formatArr2);
            trackGroupArr[i15] = new TrackGroup(string, formatArr2);
            trackGroupInfoArr[i15] = TrackGroupInfo.primaryTrack(adaptationSet.type, iArr2, i15, i18, i11);
            if (i18 != -1) {
                String str = string + ":emsg";
                trackGroupArr[i18] = new TrackGroup(str, new Format.Builder().setId(str).setSampleMimeType(MimeTypes.APPLICATION_EMSG).build());
                trackGroupInfoArr[i18] = TrackGroupInfo.embeddedEmsgTrack(iArr2, i15);
                i13 = -1;
            } else {
                i13 = -1;
            }
            if (i11 != i13) {
                trackGroupInfoArr[i11] = TrackGroupInfo.embeddedClosedCaptionTrack(iArr2, i15, y.n(formatArr[i14]));
                maybeUpdateFormatsForParsedText(factory, formatArr[i14]);
                trackGroupArr[i11] = new TrackGroup(string + ":cc", formatArr[i14]);
            }
            i14++;
            i15 = i12;
        }
        return i15;
    }

    private ChunkSampleStream<DashChunkSource> buildSampleStream(TrackGroupInfo trackGroupInfo, ExoTrackSelection exoTrackSelection, long j10) {
        int i10;
        TrackGroup trackGroup;
        int i11;
        int i12 = trackGroupInfo.embeddedEventMessageTrackGroupIndex;
        boolean z10 = i12 != -1;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandlerNewPlayerTrackEmsgHandler = null;
        if (z10) {
            trackGroup = this.trackGroups.get(i12);
            i10 = 1;
        } else {
            i10 = 0;
            trackGroup = null;
        }
        int i13 = trackGroupInfo.embeddedClosedCaptionTrackGroupIndex;
        y<Format> yVarQ = i13 != -1 ? this.trackGroupInfos[i13].embeddedClosedCaptionTrackOriginalFormats : y.q();
        int size = i10 + yVarQ.size();
        Format[] formatArr = new Format[size];
        int[] iArr = new int[size];
        if (z10) {
            formatArr[0] = trackGroup.getFormat(0);
            iArr[0] = 5;
            i11 = 1;
        } else {
            i11 = 0;
        }
        ArrayList arrayList = new ArrayList();
        for (int i14 = 0; i14 < yVarQ.size(); i14++) {
            Format format = yVarQ.get(i14);
            formatArr[i11] = format;
            iArr[i11] = 3;
            arrayList.add(format);
            i11++;
        }
        if (this.manifest.dynamic && z10) {
            playerTrackEmsgHandlerNewPlayerTrackEmsgHandler = this.playerEmsgHandler.newPlayerTrackEmsgHandler();
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = playerTrackEmsgHandlerNewPlayerTrackEmsgHandler;
        ChunkSampleStream<DashChunkSource> chunkSampleStream = new ChunkSampleStream<>(trackGroupInfo.trackType, iArr, formatArr, this.chunkSourceFactory.createDashChunkSource(this.manifestLoaderErrorThrower, this.manifest, this.baseUrlExclusionList, this.periodIndex, trackGroupInfo.adaptationSetIndices, exoTrackSelection, trackGroupInfo.trackType, this.elapsedRealtimeOffsetMs, z10, arrayList, playerTrackEmsgHandler, this.transferListener, this.playerId, this.cmcdConfiguration), this, this.allocator, j10, this.drmSessionManager, this.drmEventDispatcher, this.loadErrorHandlingPolicy, this.mediaSourceEventDispatcher);
        synchronized (this) {
            this.trackEmsgHandlerBySampleStream.put(chunkSampleStream, playerTrackEmsgHandler);
        }
        return chunkSampleStream;
    }

    private static Pair<TrackGroupArray, TrackGroupInfo[]> buildTrackGroups(DrmSessionManager drmSessionManager, DashChunkSource.Factory factory, List<AdaptationSet> list, List<EventStream> list2) {
        int[][] groupedAdaptationSetIndices = getGroupedAdaptationSetIndices(list);
        int length = groupedAdaptationSetIndices.length;
        boolean[] zArr = new boolean[length];
        Format[][] formatArr = new Format[length][];
        int iIdentifyEmbeddedTracks = identifyEmbeddedTracks(length, list, groupedAdaptationSetIndices, zArr, formatArr) + length + list2.size();
        TrackGroup[] trackGroupArr = new TrackGroup[iIdentifyEmbeddedTracks];
        TrackGroupInfo[] trackGroupInfoArr = new TrackGroupInfo[iIdentifyEmbeddedTracks];
        buildManifestEventTrackGroupInfos(list2, trackGroupArr, trackGroupInfoArr, buildPrimaryAndEmbeddedTrackGroupInfos(drmSessionManager, factory, list, groupedAdaptationSetIndices, length, zArr, formatArr, trackGroupArr, trackGroupInfoArr));
        return Pair.create(new TrackGroupArray(trackGroupArr), trackGroupInfoArr);
    }

    @Nullable
    private static Descriptor findAdaptationSetSwitchingProperty(List<Descriptor> list) {
        return findDescriptor(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    @Nullable
    private static Descriptor findDescriptor(List<Descriptor> list, String str) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            Descriptor descriptor = list.get(i10);
            if (str.equals(descriptor.schemeIdUri)) {
                return descriptor;
            }
        }
        return null;
    }

    @Nullable
    private static Descriptor findTrickPlayProperty(List<Descriptor> list) {
        return findDescriptor(list, "http://dashif.org/guidelines/trickmode");
    }

    private static Format[] getClosedCaptionTrackFormats(List<AdaptationSet> list, int[] iArr) {
        for (int i10 : iArr) {
            AdaptationSet adaptationSet = list.get(i10);
            List<Descriptor> list2 = list.get(i10).accessibilityDescriptors;
            for (int i11 = 0; i11 < list2.size(); i11++) {
                Descriptor descriptor = list2.get(i11);
                if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri)) {
                    return parseClosedCaptionDescriptor(descriptor, CEA608_SERVICE_DESCRIPTOR_REGEX, new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_CEA608).setId(adaptationSet.id + ":cea608").build());
                }
                if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri)) {
                    return parseClosedCaptionDescriptor(descriptor, CEA708_SERVICE_DESCRIPTOR_REGEX, new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_CEA708).setId(adaptationSet.id + ":cea708").build());
                }
            }
        }
        return new Format[0];
    }

    private static int[][] getGroupedAdaptationSetIndices(List<AdaptationSet> list) {
        Descriptor descriptorFindAdaptationSetSwitchingProperty;
        Integer num;
        int size = list.size();
        HashMap mapH = k0.h(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i10 = 0; i10 < size; i10++) {
            mapH.put(Long.valueOf(list.get(i10).id), Integer.valueOf(i10));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i10));
            arrayList.add(arrayList2);
            sparseArray.put(i10, arrayList2);
        }
        for (int i11 = 0; i11 < size; i11++) {
            AdaptationSet adaptationSet = list.get(i11);
            Descriptor descriptorFindTrickPlayProperty = findTrickPlayProperty(adaptationSet.essentialProperties);
            if (descriptorFindTrickPlayProperty == null) {
                descriptorFindTrickPlayProperty = findTrickPlayProperty(adaptationSet.supplementalProperties);
            }
            int iIntValue = (descriptorFindTrickPlayProperty == null || (num = (Integer) mapH.get(Long.valueOf(Long.parseLong(descriptorFindTrickPlayProperty.value)))) == null) ? i11 : num.intValue();
            if (iIntValue == i11 && (descriptorFindAdaptationSetSwitchingProperty = findAdaptationSetSwitchingProperty(adaptationSet.supplementalProperties)) != null) {
                for (String str : Util.split(descriptorFindAdaptationSetSwitchingProperty.value, ",")) {
                    Integer num2 = (Integer) mapH.get(Long.valueOf(Long.parseLong(str)));
                    if (num2 != null) {
                        iIntValue = Math.min(iIntValue, num2.intValue());
                    }
                }
            }
            if (iIntValue != i11) {
                List list2 = (List) sparseArray.get(i11);
                List list3 = (List) sparseArray.get(iIntValue);
                list3.addAll(list2);
                sparseArray.put(i11, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i12 = 0; i12 < size2; i12++) {
            int[] iArrK = g5.e.k((Collection) arrayList.get(i12));
            iArr[i12] = iArrK;
            Arrays.sort(iArrK);
        }
        return iArr;
    }

    private int getPrimaryStreamIndex(int i10, int[] iArr) {
        int i11 = iArr[i10];
        if (i11 == -1) {
            return -1;
        }
        int i12 = this.trackGroupInfos[i11].primaryTrackGroupIndex;
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            if (i14 == i12 && this.trackGroupInfos[i14].trackGroupCategory == 0) {
                return i13;
            }
        }
        return -1;
    }

    private int[] getStreamIndexToTrackGroupIndex(ExoTrackSelection[] exoTrackSelectionArr) {
        int[] iArr = new int[exoTrackSelectionArr.length];
        for (int i10 = 0; i10 < exoTrackSelectionArr.length; i10++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i10];
            if (exoTrackSelection != null) {
                iArr[i10] = this.trackGroups.indexOf(exoTrackSelection.getTrackGroup());
            } else {
                iArr[i10] = -1;
            }
        }
        return iArr;
    }

    private static boolean hasEventMessageTrack(List<AdaptationSet> list, int[] iArr) {
        for (int i10 : iArr) {
            List<Representation> list2 = list.get(i10).representations;
            for (int i11 = 0; i11 < list2.size(); i11++) {
                if (!list2.get(i11).inbandEventStreams.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int identifyEmbeddedTracks(int i10, List<AdaptationSet> list, int[][] iArr, boolean[] zArr, Format[][] formatArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            if (hasEventMessageTrack(list, iArr[i12])) {
                zArr[i12] = true;
                i11++;
            }
            Format[] closedCaptionTrackFormats = getClosedCaptionTrackFormats(list, iArr[i12]);
            formatArr[i12] = closedCaptionTrackFormats;
            if (closedCaptionTrackFormats.length != 0) {
                i11++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$selectTracks$0(ChunkSampleStream chunkSampleStream) {
        return y.r(Integer.valueOf(chunkSampleStream.primaryTrackType));
    }

    private static void maybeUpdateFormatsForParsedText(DashChunkSource.Factory factory, Format[] formatArr) {
        for (int i10 = 0; i10 < formatArr.length; i10++) {
            formatArr[i10] = factory.getOutputTextFormat(formatArr[i10]);
        }
    }

    private static ChunkSampleStream<DashChunkSource>[] newSampleStreamArray(int i10) {
        return new ChunkSampleStream[i10];
    }

    private static Format[] parseClosedCaptionDescriptor(Descriptor descriptor, Pattern pattern, Format format) {
        String str = descriptor.value;
        if (str == null) {
            return new Format[]{format};
        }
        String[] strArrSplit = Util.split(str, ";");
        Format[] formatArr = new Format[strArrSplit.length];
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            Matcher matcher = pattern.matcher(strArrSplit[i10]);
            if (!matcher.matches()) {
                return new Format[]{format};
            }
            int i11 = Integer.parseInt(matcher.group(1));
            formatArr[i10] = format.buildUpon().setId(format.id + ":" + i11).setAccessibilityChannel(i11).setLanguage(matcher.group(2)).build();
        }
        return formatArr;
    }

    private void releaseDisabledStreams(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr) {
        for (int i10 = 0; i10 < exoTrackSelectionArr.length; i10++) {
            if (exoTrackSelectionArr[i10] == null || !zArr[i10]) {
                SampleStream sampleStream = sampleStreamArr[i10];
                if (sampleStream instanceof ChunkSampleStream) {
                    ((ChunkSampleStream) sampleStream).release(this);
                } else if (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) {
                    ((ChunkSampleStream.EmbeddedSampleStream) sampleStream).release();
                }
                sampleStreamArr[i10] = null;
            }
        }
    }

    private void releaseOrphanEmbeddedStreams(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, int[] iArr) {
        boolean z10;
        for (int i10 = 0; i10 < exoTrackSelectionArr.length; i10++) {
            SampleStream sampleStream = sampleStreamArr[i10];
            if ((sampleStream instanceof EmptySampleStream) || (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream)) {
                int primaryStreamIndex = getPrimaryStreamIndex(i10, iArr);
                if (primaryStreamIndex == -1) {
                    z10 = sampleStreamArr[i10] instanceof EmptySampleStream;
                } else {
                    SampleStream sampleStream2 = sampleStreamArr[i10];
                    z10 = (sampleStream2 instanceof ChunkSampleStream.EmbeddedSampleStream) && ((ChunkSampleStream.EmbeddedSampleStream) sampleStream2).parent == sampleStreamArr[primaryStreamIndex];
                }
                if (!z10) {
                    SampleStream sampleStream3 = sampleStreamArr[i10];
                    if (sampleStream3 instanceof ChunkSampleStream.EmbeddedSampleStream) {
                        ((ChunkSampleStream.EmbeddedSampleStream) sampleStream3).release();
                    }
                    sampleStreamArr[i10] = null;
                }
            }
        }
    }

    private void selectNewStreams(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, boolean[] zArr, long j10, int[] iArr) {
        for (int i10 = 0; i10 < exoTrackSelectionArr.length; i10++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i10];
            if (exoTrackSelection != null) {
                SampleStream sampleStream = sampleStreamArr[i10];
                if (sampleStream == null) {
                    zArr[i10] = true;
                    TrackGroupInfo trackGroupInfo = this.trackGroupInfos[iArr[i10]];
                    int i11 = trackGroupInfo.trackGroupCategory;
                    if (i11 == 0) {
                        sampleStreamArr[i10] = buildSampleStream(trackGroupInfo, exoTrackSelection, j10);
                    } else if (i11 == 2) {
                        sampleStreamArr[i10] = new EventSampleStream(this.eventStreams.get(trackGroupInfo.eventStreamGroupIndex), exoTrackSelection.getTrackGroup().getFormat(0), this.manifest.dynamic);
                    }
                } else if (sampleStream instanceof ChunkSampleStream) {
                    ((DashChunkSource) ((ChunkSampleStream) sampleStream).getChunkSource()).updateTrackSelection(exoTrackSelection);
                }
            }
        }
        for (int i12 = 0; i12 < exoTrackSelectionArr.length; i12++) {
            if (sampleStreamArr[i12] == null && exoTrackSelectionArr[i12] != null) {
                TrackGroupInfo trackGroupInfo2 = this.trackGroupInfos[iArr[i12]];
                if (trackGroupInfo2.trackGroupCategory == 1) {
                    int primaryStreamIndex = getPrimaryStreamIndex(i12, iArr);
                    if (primaryStreamIndex == -1) {
                        sampleStreamArr[i12] = new EmptySampleStream();
                    } else {
                        sampleStreamArr[i12] = ((ChunkSampleStream) sampleStreamArr[primaryStreamIndex]).selectEmbeddedTrack(j10, trackGroupInfo2.trackType);
                    }
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean continueLoading(LoadingInfo loadingInfo) {
        return this.compositeSequenceableLoader.continueLoading(loadingInfo);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void discardBuffer(long j10, boolean z10) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.discardBuffer(j10, z10);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j10, SeekParameters seekParameters) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
            if (chunkSampleStream.primaryTrackType == 2) {
                return chunkSampleStream.getAdjustedSeekPositionUs(j10, seekParameters);
            }
        }
        return j10;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        List<AdaptationSet> list2 = this.manifest.getPeriod(this.periodIndex).adaptationSets;
        ArrayList arrayList = new ArrayList();
        for (ExoTrackSelection exoTrackSelection : list) {
            TrackGroupInfo trackGroupInfo = this.trackGroupInfos[this.trackGroups.indexOf(exoTrackSelection.getTrackGroup())];
            if (trackGroupInfo.trackGroupCategory == 0) {
                int[] iArr = trackGroupInfo.adaptationSetIndices;
                int length = exoTrackSelection.length();
                int[] iArr2 = new int[length];
                for (int i10 = 0; i10 < exoTrackSelection.length(); i10++) {
                    iArr2[i10] = exoTrackSelection.getIndexInTrackGroup(i10);
                }
                Arrays.sort(iArr2);
                int size = list2.get(iArr[0]).representations.size();
                int i11 = 0;
                int i12 = 0;
                for (int i13 = 0; i13 < length; i13++) {
                    int i14 = iArr2[i13];
                    while (true) {
                        int i15 = i12 + size;
                        if (i14 >= i15) {
                            i11++;
                            size = list2.get(iArr[i11]).representations.size();
                            i12 = i15;
                        }
                    }
                    arrayList.add(new StreamKey(this.periodIndex, iArr[i11], i14 - i12));
                }
            }
        }
        return arrayList;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSampleStream.ReleaseCallback
    public synchronized void onSampleStreamReleased(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandlerRemove = this.trackEmsgHandlerBySampleStream.remove(chunkSampleStream);
        if (playerTrackEmsgHandlerRemove != null) {
            playerTrackEmsgHandlerRemove.release();
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j10) {
        this.callback = callback;
        callback.onPrepared(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public void reevaluateBuffer(long j10) {
        this.compositeSequenceableLoader.reevaluateBuffer(j10);
    }

    public void release() {
        this.playerEmsgHandler.release();
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.release(this);
        }
        this.callback = null;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long seekToUs(long j10) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.seekToUs(j10);
        }
        for (EventSampleStream eventSampleStream : this.eventSampleStreams) {
            eventSampleStream.seekToUs(j10);
        }
        return j10;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
        int[] streamIndexToTrackGroupIndex = getStreamIndexToTrackGroupIndex(exoTrackSelectionArr);
        releaseDisabledStreams(exoTrackSelectionArr, zArr, sampleStreamArr);
        releaseOrphanEmbeddedStreams(exoTrackSelectionArr, sampleStreamArr, streamIndexToTrackGroupIndex);
        selectNewStreams(exoTrackSelectionArr, sampleStreamArr, zArr2, j10, streamIndexToTrackGroupIndex);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SampleStream sampleStream : sampleStreamArr) {
            if (sampleStream instanceof ChunkSampleStream) {
                arrayList.add((ChunkSampleStream) sampleStream);
            } else if (sampleStream instanceof EventSampleStream) {
                arrayList2.add((EventSampleStream) sampleStream);
            }
        }
        ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArrNewSampleStreamArray = newSampleStreamArray(arrayList.size());
        this.sampleStreams = chunkSampleStreamArrNewSampleStreamArray;
        arrayList.toArray(chunkSampleStreamArrNewSampleStreamArray);
        EventSampleStream[] eventSampleStreamArr = new EventSampleStream[arrayList2.size()];
        this.eventSampleStreams = eventSampleStreamArr;
        arrayList2.toArray(eventSampleStreamArr);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.create(arrayList, j0.k(arrayList, new g() { // from class: androidx.media3.exoplayer.dash.c
            @Override // e5.g
            public final Object apply(Object obj) {
                return DashMediaPeriod.lambda$selectTracks$0((ChunkSampleStream) obj);
            }
        }));
        return j10;
    }

    public void updateManifest(DashManifest dashManifest, int i10) {
        this.manifest = dashManifest;
        this.periodIndex = i10;
        this.playerEmsgHandler.updateManifest(dashManifest);
        ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArr = this.sampleStreams;
        if (chunkSampleStreamArr != null) {
            for (ChunkSampleStream<DashChunkSource> chunkSampleStream : chunkSampleStreamArr) {
                ((DashChunkSource) chunkSampleStream.getChunkSource()).updateManifest(dashManifest, i10);
            }
            this.callback.onContinueLoadingRequested(this);
        }
        this.eventStreams = dashManifest.getPeriod(i10).eventStreams;
        for (EventSampleStream eventSampleStream : this.eventSampleStreams) {
            Iterator<EventStream> it = this.eventStreams.iterator();
            while (true) {
                if (it.hasNext()) {
                    EventStream next = it.next();
                    if (next.id().equals(eventSampleStream.eventStreamId())) {
                        eventSampleStream.updateEventStream(next, dashManifest.dynamic && i10 == dashManifest.getPeriodCount() - 1);
                    }
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        this.callback.onContinueLoadingRequested(this);
    }
}
