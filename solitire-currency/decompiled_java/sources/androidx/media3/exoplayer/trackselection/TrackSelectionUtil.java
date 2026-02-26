package androidx.media3.exoplayer.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.google.common.collect.y;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class TrackSelectionUtil {

    public interface AdaptiveTrackSelectionFactory {
        ExoTrackSelection createAdaptiveTrackSelection(ExoTrackSelection.Definition definition);
    }

    private TrackSelectionUtil() {
    }

    public static Tracks buildTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelection[] trackSelectionArr) {
        List[] listArr = new List[trackSelectionArr.length];
        for (int i10 = 0; i10 < trackSelectionArr.length; i10++) {
            TrackSelection trackSelection = trackSelectionArr[i10];
            listArr[i10] = trackSelection != null ? y.r(trackSelection) : y.q();
        }
        return buildTracks(mappedTrackInfo, (List<? extends TrackSelection>[]) listArr);
    }

    public static LoadErrorHandlingPolicy.FallbackOptions createFallbackOptions(ExoTrackSelection exoTrackSelection) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (exoTrackSelection.isTrackExcluded(i11, jElapsedRealtime)) {
                i10++;
            }
        }
        return new LoadErrorHandlingPolicy.FallbackOptions(1, 0, length, i10);
    }

    public static ExoTrackSelection[] createTrackSelectionsForDefinitions(ExoTrackSelection.Definition[] definitionArr, AdaptiveTrackSelectionFactory adaptiveTrackSelectionFactory) {
        ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
        boolean z10 = false;
        for (int i10 = 0; i10 < definitionArr.length; i10++) {
            ExoTrackSelection.Definition definition = definitionArr[i10];
            if (definition != null) {
                int[] iArr = definition.tracks;
                if (iArr.length <= 1 || z10) {
                    exoTrackSelectionArr[i10] = new FixedTrackSelection(definition.group, iArr[0], definition.type);
                } else {
                    exoTrackSelectionArr[i10] = adaptiveTrackSelectionFactory.createAdaptiveTrackSelection(definition);
                    z10 = true;
                }
            }
        }
        return exoTrackSelectionArr;
    }

    @Deprecated
    public static DefaultTrackSelector.Parameters updateParametersWithOverride(DefaultTrackSelector.Parameters parameters, int i10, TrackGroupArray trackGroupArray, boolean z10, @Nullable DefaultTrackSelector.SelectionOverride selectionOverride) {
        DefaultTrackSelector.Parameters.Builder rendererDisabled = parameters.buildUpon().clearSelectionOverrides(i10).setRendererDisabled(i10, z10);
        if (selectionOverride != null) {
            rendererDisabled.setSelectionOverride(i10, trackGroupArray, selectionOverride);
        }
        return rendererDisabled.build();
    }

    public static Tracks buildTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, List<? extends TrackSelection>[] listArr) {
        boolean z10;
        y.a aVar = new y.a();
        for (int i10 = 0; i10 < mappedTrackInfo.getRendererCount(); i10++) {
            TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i10);
            List<? extends TrackSelection> list = listArr[i10];
            for (int i11 = 0; i11 < trackGroups.length; i11++) {
                TrackGroup trackGroup = trackGroups.get(i11);
                boolean z11 = mappedTrackInfo.getAdaptiveSupport(i10, i11, false) != 0;
                int i12 = trackGroup.length;
                int[] iArr = new int[i12];
                boolean[] zArr = new boolean[i12];
                for (int i13 = 0; i13 < trackGroup.length; i13++) {
                    iArr[i13] = mappedTrackInfo.getTrackSupport(i10, i11, i13);
                    int i14 = 0;
                    while (true) {
                        if (i14 >= list.size()) {
                            z10 = false;
                            break;
                        }
                        TrackSelection trackSelection = list.get(i14);
                        if (trackSelection.getTrackGroup().equals(trackGroup) && trackSelection.indexOf(i13) != -1) {
                            z10 = true;
                            break;
                        }
                        i14++;
                    }
                    zArr[i13] = z10;
                }
                aVar.a(new Tracks.Group(trackGroup, z11, iArr, zArr));
            }
        }
        TrackGroupArray unmappedTrackGroups = mappedTrackInfo.getUnmappedTrackGroups();
        for (int i15 = 0; i15 < unmappedTrackGroups.length; i15++) {
            TrackGroup trackGroup2 = unmappedTrackGroups.get(i15);
            int[] iArr2 = new int[trackGroup2.length];
            Arrays.fill(iArr2, 0);
            aVar.a(new Tracks.Group(trackGroup2, false, iArr2, new boolean[trackGroup2.length]));
        }
        return new Tracks(aVar.k());
    }
}
