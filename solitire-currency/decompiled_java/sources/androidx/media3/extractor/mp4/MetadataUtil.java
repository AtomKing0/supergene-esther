package androidx.media3.extractor.mp4;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.metadata.id3.ApicFrame;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.Id3Frame;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.google.common.collect.y;
import com.unity3d.services.UnityAdsConstants;

/* JADX INFO: loaded from: classes2.dex */
final class MetadataUtil {
    private static final int PICTURE_TYPE_FRONT_COVER = 3;
    private static final int SHORT_TYPE_ALBUM = 6384738;
    private static final int SHORT_TYPE_ARTIST = 4280916;
    private static final int SHORT_TYPE_COMMENT = 6516084;
    private static final int SHORT_TYPE_COMPOSER_1 = 6516589;
    private static final int SHORT_TYPE_COMPOSER_2 = 7828084;
    private static final int SHORT_TYPE_ENCODER = 7630703;
    private static final int SHORT_TYPE_GENRE = 6776174;
    private static final int SHORT_TYPE_LYRICS = 7108978;
    private static final int SHORT_TYPE_NAME_1 = 7233901;
    private static final int SHORT_TYPE_NAME_2 = 7631467;
    private static final int SHORT_TYPE_YEAR = 6578553;

    @VisibleForTesting
    static final String[] STANDARD_GENRES = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    private static final String TAG = "MetadataUtil";
    private static final int TYPE_ALBUM_ARTIST = 1631670868;
    private static final int TYPE_COMPILATION = 1668311404;
    private static final int TYPE_COVER_ART = 1668249202;
    private static final int TYPE_DISK_NUMBER = 1684632427;
    private static final int TYPE_GAPLESS_ALBUM = 1885823344;
    private static final int TYPE_GENRE = 1735291493;
    private static final int TYPE_GROUPING = 6779504;
    private static final int TYPE_INTERNAL = 757935405;
    private static final int TYPE_RATING = 1920233063;
    private static final int TYPE_SORT_ALBUM = 1936679276;
    private static final int TYPE_SORT_ALBUM_ARTIST = 1936679265;
    private static final int TYPE_SORT_ARTIST = 1936679282;
    private static final int TYPE_SORT_COMPOSER = 1936679791;
    private static final int TYPE_SORT_TRACK_NAME = 1936682605;
    private static final int TYPE_TEMPO = 1953329263;
    private static final int TYPE_TOP_BYTE_COPYRIGHT = 169;
    private static final int TYPE_TOP_BYTE_REPLACEMENT = 253;
    private static final int TYPE_TRACK_NUMBER = 1953655662;
    private static final int TYPE_TV_SHOW = 1953919848;
    private static final int TYPE_TV_SORT_SHOW = 1936683886;

    private MetadataUtil() {
    }

    @Nullable
    private static CommentFrame parseCommentAttribute(int i10, ParsableByteArray parsableByteArray) {
        int i11 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            String nullTerminatedString = parsableByteArray.readNullTerminatedString(i11 - 16);
            return new CommentFrame(C.LANGUAGE_UNDETERMINED, nullTerminatedString, nullTerminatedString);
        }
        Log.w(TAG, "Failed to parse comment attribute: " + Atom.getAtomTypeString(i10));
        return null;
    }

    @Nullable
    private static ApicFrame parseCoverArt(ParsableByteArray parsableByteArray) {
        int i10 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() != 1684108385) {
            Log.w(TAG, "Failed to parse cover art attribute");
            return null;
        }
        int fullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        String str = fullAtomFlags == 13 ? MimeTypes.IMAGE_JPEG : fullAtomFlags == 14 ? MimeTypes.IMAGE_PNG : null;
        if (str == null) {
            Log.w(TAG, "Unrecognized cover art flags: " + fullAtomFlags);
            return null;
        }
        parsableByteArray.skipBytes(4);
        int i11 = i10 - 16;
        byte[] bArr = new byte[i11];
        parsableByteArray.readBytes(bArr, 0, i11);
        return new ApicFrame(str, null, 3, bArr);
    }

    @Nullable
    public static Metadata.Entry parseIlstElement(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition() + parsableByteArray.readInt();
        int i10 = parsableByteArray.readInt();
        int i11 = (i10 >> 24) & 255;
        try {
            if (i11 == TYPE_TOP_BYTE_COPYRIGHT || i11 == TYPE_TOP_BYTE_REPLACEMENT) {
                int i12 = 16777215 & i10;
                if (i12 == SHORT_TYPE_COMMENT) {
                    return parseCommentAttribute(i10, parsableByteArray);
                }
                if (i12 == SHORT_TYPE_NAME_1 || i12 == SHORT_TYPE_NAME_2) {
                    return parseTextAttribute(i10, "TIT2", parsableByteArray);
                }
                if (i12 == SHORT_TYPE_COMPOSER_1 || i12 == SHORT_TYPE_COMPOSER_2) {
                    return parseTextAttribute(i10, "TCOM", parsableByteArray);
                }
                if (i12 == SHORT_TYPE_YEAR) {
                    return parseTextAttribute(i10, "TDRC", parsableByteArray);
                }
                if (i12 == SHORT_TYPE_ARTIST) {
                    return parseTextAttribute(i10, "TPE1", parsableByteArray);
                }
                if (i12 == SHORT_TYPE_ENCODER) {
                    return parseTextAttribute(i10, "TSSE", parsableByteArray);
                }
                if (i12 == SHORT_TYPE_ALBUM) {
                    return parseTextAttribute(i10, "TALB", parsableByteArray);
                }
                if (i12 == SHORT_TYPE_LYRICS) {
                    return parseTextAttribute(i10, "USLT", parsableByteArray);
                }
                if (i12 == SHORT_TYPE_GENRE) {
                    return parseTextAttribute(i10, "TCON", parsableByteArray);
                }
                if (i12 == TYPE_GROUPING) {
                    return parseTextAttribute(i10, "TIT1", parsableByteArray);
                }
            } else {
                if (i10 == TYPE_GENRE) {
                    return parseStandardGenreAttribute(parsableByteArray);
                }
                if (i10 == TYPE_DISK_NUMBER) {
                    return parseIndexAndCountAttribute(i10, "TPOS", parsableByteArray);
                }
                if (i10 == TYPE_TRACK_NUMBER) {
                    return parseIndexAndCountAttribute(i10, "TRCK", parsableByteArray);
                }
                if (i10 == TYPE_TEMPO) {
                    return parseUint8Attribute(i10, "TBPM", parsableByteArray, true, false);
                }
                if (i10 == TYPE_COMPILATION) {
                    return parseUint8Attribute(i10, "TCMP", parsableByteArray, true, true);
                }
                if (i10 == TYPE_COVER_ART) {
                    return parseCoverArt(parsableByteArray);
                }
                if (i10 == TYPE_ALBUM_ARTIST) {
                    return parseTextAttribute(i10, "TPE2", parsableByteArray);
                }
                if (i10 == TYPE_SORT_TRACK_NAME) {
                    return parseTextAttribute(i10, "TSOT", parsableByteArray);
                }
                if (i10 == TYPE_SORT_ALBUM) {
                    return parseTextAttribute(i10, "TSO2", parsableByteArray);
                }
                if (i10 == TYPE_SORT_ARTIST) {
                    return parseTextAttribute(i10, "TSOA", parsableByteArray);
                }
                if (i10 == TYPE_SORT_ALBUM_ARTIST) {
                    return parseTextAttribute(i10, "TSOP", parsableByteArray);
                }
                if (i10 == TYPE_SORT_COMPOSER) {
                    return parseTextAttribute(i10, "TSOC", parsableByteArray);
                }
                if (i10 == TYPE_RATING) {
                    return parseUint8Attribute(i10, "ITUNESADVISORY", parsableByteArray, false, false);
                }
                if (i10 == TYPE_GAPLESS_ALBUM) {
                    return parseUint8Attribute(i10, "ITUNESGAPLESS", parsableByteArray, false, true);
                }
                if (i10 == TYPE_TV_SORT_SHOW) {
                    return parseTextAttribute(i10, "TVSHOWSORT", parsableByteArray);
                }
                if (i10 == TYPE_TV_SHOW) {
                    return parseTextAttribute(i10, "TVSHOW", parsableByteArray);
                }
                if (i10 == TYPE_INTERNAL) {
                    return parseInternalAttribute(parsableByteArray, position);
                }
            }
            Log.d(TAG, "Skipped unknown metadata entry: " + Atom.getAtomTypeString(i10));
            parsableByteArray.setPosition(position);
            return null;
        } finally {
            parsableByteArray.setPosition(position);
        }
    }

    @Nullable
    private static TextInformationFrame parseIndexAndCountAttribute(int i10, String str, ParsableByteArray parsableByteArray) {
        int i11 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385 && i11 >= 22) {
            parsableByteArray.skipBytes(10);
            int unsignedShort = parsableByteArray.readUnsignedShort();
            if (unsignedShort > 0) {
                String str2 = "" + unsignedShort;
                int unsignedShort2 = parsableByteArray.readUnsignedShort();
                if (unsignedShort2 > 0) {
                    str2 = str2 + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH + unsignedShort2;
                }
                return new TextInformationFrame(str, (String) null, y.r(str2));
            }
        }
        Log.w(TAG, "Failed to parse index/count attribute: " + Atom.getAtomTypeString(i10));
        return null;
    }

    @Nullable
    private static Id3Frame parseInternalAttribute(ParsableByteArray parsableByteArray, int i10) {
        String nullTerminatedString = null;
        String nullTerminatedString2 = null;
        int i11 = -1;
        int i12 = -1;
        while (parsableByteArray.getPosition() < i10) {
            int position = parsableByteArray.getPosition();
            int i13 = parsableByteArray.readInt();
            int i14 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            if (i14 == 1835360622) {
                nullTerminatedString = parsableByteArray.readNullTerminatedString(i13 - 12);
            } else if (i14 == 1851878757) {
                nullTerminatedString2 = parsableByteArray.readNullTerminatedString(i13 - 12);
            } else {
                if (i14 == 1684108385) {
                    i11 = position;
                    i12 = i13;
                }
                parsableByteArray.skipBytes(i13 - 12);
            }
        }
        if (nullTerminatedString == null || nullTerminatedString2 == null || i11 == -1) {
            return null;
        }
        parsableByteArray.setPosition(i11);
        parsableByteArray.skipBytes(16);
        return new InternalFrame(nullTerminatedString, nullTerminatedString2, parsableByteArray.readNullTerminatedString(i12 - 16));
    }

    @Nullable
    public static MdtaMetadataEntry parseMdtaMetadataEntryFromIlst(ParsableByteArray parsableByteArray, int i10, String str) {
        while (true) {
            int position = parsableByteArray.getPosition();
            if (position >= i10) {
                return null;
            }
            int i11 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1684108385) {
                int i12 = parsableByteArray.readInt();
                int i13 = parsableByteArray.readInt();
                int i14 = i11 - 16;
                byte[] bArr = new byte[i14];
                parsableByteArray.readBytes(bArr, 0, i14);
                return new MdtaMetadataEntry(str, bArr, i13, i12);
            }
            parsableByteArray.setPosition(position + i11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.media3.extractor.metadata.id3.TextInformationFrame parseStandardGenreAttribute(androidx.media3.common.util.ParsableByteArray r3) {
        /*
            int r3 = parseUint8AttributeValue(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = androidx.media3.extractor.mp4.MetadataUtil.STANDARD_GENRES
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L20
            androidx.media3.extractor.metadata.id3.TextInformationFrame r1 = new androidx.media3.extractor.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            com.google.common.collect.y r3 = com.google.common.collect.y.r(r3)
            r1.<init>(r2, r0, r3)
            return r1
        L20:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            androidx.media3.common.util.Log.w(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.MetadataUtil.parseStandardGenreAttribute(androidx.media3.common.util.ParsableByteArray):androidx.media3.extractor.metadata.id3.TextInformationFrame");
    }

    @Nullable
    private static TextInformationFrame parseTextAttribute(int i10, String str, ParsableByteArray parsableByteArray) {
        int i11 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return new TextInformationFrame(str, (String) null, y.r(parsableByteArray.readNullTerminatedString(i11 - 16)));
        }
        Log.w(TAG, "Failed to parse text attribute: " + Atom.getAtomTypeString(i10));
        return null;
    }

    @Nullable
    private static Id3Frame parseUint8Attribute(int i10, String str, ParsableByteArray parsableByteArray, boolean z10, boolean z11) {
        int uint8AttributeValue = parseUint8AttributeValue(parsableByteArray);
        if (z11) {
            uint8AttributeValue = Math.min(1, uint8AttributeValue);
        }
        if (uint8AttributeValue >= 0) {
            return z10 ? new TextInformationFrame(str, (String) null, y.r(Integer.toString(uint8AttributeValue))) : new CommentFrame(C.LANGUAGE_UNDETERMINED, str, Integer.toString(uint8AttributeValue));
        }
        Log.w(TAG, "Failed to parse uint8 attribute: " + Atom.getAtomTypeString(i10));
        return null;
    }

    private static int parseUint8AttributeValue(ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return parsableByteArray.readUnsignedByte();
        }
        Log.w(TAG, "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void setFormatGaplessInfo(int i10, GaplessInfoHolder gaplessInfoHolder, Format.Builder builder) {
        if (i10 == 1 && gaplessInfoHolder.hasGaplessInfo()) {
            builder.setEncoderDelay(gaplessInfoHolder.encoderDelay).setEncoderPadding(gaplessInfoHolder.encoderPadding);
        }
    }

    public static void setFormatMetadata(int i10, @Nullable Metadata metadata, Format.Builder builder, Metadata... metadataArr) {
        Metadata metadata2 = new Metadata(new Metadata.Entry[0]);
        if (metadata != null) {
            for (int i11 = 0; i11 < metadata.length(); i11++) {
                Metadata.Entry entry = metadata.get(i11);
                if (entry instanceof MdtaMetadataEntry) {
                    MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entry;
                    if (!mdtaMetadataEntry.key.equals(MdtaMetadataEntry.KEY_ANDROID_CAPTURE_FPS)) {
                        metadata2 = metadata2.copyWithAppendedEntries(mdtaMetadataEntry);
                    } else if (i10 == 2) {
                        metadata2 = metadata2.copyWithAppendedEntries(mdtaMetadataEntry);
                    }
                }
            }
        }
        for (Metadata metadata3 : metadataArr) {
            metadata2 = metadata2.copyWithAppendedEntriesFrom(metadata3);
        }
        if (metadata2.length() > 0) {
            builder.setMetadata(metadata2);
        }
    }
}
