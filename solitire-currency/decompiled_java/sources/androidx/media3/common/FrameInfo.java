package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public class FrameInfo {
    public final ColorInfo colorInfo;
    public final int height;
    public final long offsetToAddUs;
    public final float pixelWidthHeightRatio;
    public final int width;

    private FrameInfo(ColorInfo colorInfo, int i10, int i11, float f10, long j10) {
        Assertions.checkArgument(i10 > 0, "width must be positive, but is: " + i10);
        Assertions.checkArgument(i11 > 0, "height must be positive, but is: " + i11);
        this.colorInfo = colorInfo;
        this.width = i10;
        this.height = i11;
        this.pixelWidthHeightRatio = f10;
        this.offsetToAddUs = j10;
    }

    public static final class Builder {
        private ColorInfo colorInfo;
        private int height;
        private long offsetToAddUs;
        private float pixelWidthHeightRatio;
        private int width;

        public Builder(ColorInfo colorInfo, int i10, int i11) {
            this.colorInfo = colorInfo;
            this.width = i10;
            this.height = i11;
            this.pixelWidthHeightRatio = 1.0f;
        }

        public FrameInfo build() {
            return new FrameInfo(this.colorInfo, this.width, this.height, this.pixelWidthHeightRatio, this.offsetToAddUs);
        }

        public Builder setColorInfo(ColorInfo colorInfo) {
            this.colorInfo = colorInfo;
            return this;
        }

        public Builder setHeight(int i10) {
            this.height = i10;
            return this;
        }

        public Builder setOffsetToAddUs(long j10) {
            this.offsetToAddUs = j10;
            return this;
        }

        public Builder setPixelWidthHeightRatio(float f10) {
            this.pixelWidthHeightRatio = f10;
            return this;
        }

        public Builder setWidth(int i10) {
            this.width = i10;
            return this;
        }

        public Builder(FrameInfo frameInfo) {
            this.colorInfo = frameInfo.colorInfo;
            this.width = frameInfo.width;
            this.height = frameInfo.height;
            this.pixelWidthHeightRatio = frameInfo.pixelWidthHeightRatio;
            this.offsetToAddUs = frameInfo.offsetToAddUs;
        }
    }
}
