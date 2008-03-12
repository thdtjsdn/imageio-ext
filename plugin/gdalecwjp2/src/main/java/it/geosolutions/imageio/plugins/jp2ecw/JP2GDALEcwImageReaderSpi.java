/*
 *    JImageIO-extension - OpenSource Java Image translation Library
 *    http://www.geo-solutions.it/
 *	  https://imageio-ext.dev.java.net/
 *    (C) 2007, GeoSolutions
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package it.geosolutions.imageio.plugins.jp2ecw;

import it.geosolutions.imageio.gdalframework.GDALImageReaderSpi;
import it.geosolutions.imageio.stream.input.FileImageInputStreamExt;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageReader;

/**
 * Service provider interface for the jp2k image
 * 
 * @author Daniele Romagnoli, GeoSolutions.
 * @author Simone Giannecchini, GeoSolutions.
 */
public class JP2GDALEcwImageReaderSpi extends GDALImageReaderSpi {

	private static final Logger LOGGER = Logger
			.getLogger("it.geosolutions.imageio.plugins.jp2ecw");

	static final String[] suffixes = { "jp2", "jp2" };

	static final String[] formatNames = { "JPEG2000" };

	static final String[] MIMETypes = { "image/jp2", "image/jp2k" };

	static final String version = "1.0";

	static final String readerCN = "it.geosolutions.imageio.plugins.jp2ecw.JP2GDALEcwImageReader";

	static final String vendorName = "GeoSolutions";

	// writerSpiNames
	static final String[] wSN = { null };

	// StreamMetadataFormatNames and StreamMetadataFormatClassNames
	static final boolean supportsStandardStreamMetadataFormat = false;

	static final String nativeStreamMetadataFormatName = null;

	static final String nativeStreamMetadataFormatClassName = null;

	static final String[] extraStreamMetadataFormatNames = { null };

	static final String[] extraStreamMetadataFormatClassNames = { null };

	// ImageMetadataFormatNames and ImageMetadataFormatClassNames
	static final boolean supportsStandardImageMetadataFormat = false;

	static final String nativeImageMetadataFormatName = null;

	static final String nativeImageMetadataFormatClassName = null;

	static final String[] extraImageMetadataFormatNames = { null };

	static final String[] extraImageMetadataFormatClassNames = { null };

	public JP2GDALEcwImageReaderSpi() {
		super(
				vendorName,
				version,
				formatNames,
				suffixes,
				MIMETypes,
				readerCN, // readerClassName
				new Class[] { File.class, FileImageInputStreamExt.class },
				wSN, // writer Spi Names
				supportsStandardStreamMetadataFormat,
				nativeStreamMetadataFormatName,
				nativeStreamMetadataFormatClassName,
				extraStreamMetadataFormatNames,
				extraStreamMetadataFormatClassNames,
				supportsStandardImageMetadataFormat,
				nativeImageMetadataFormatName,
				nativeImageMetadataFormatClassName,
				extraImageMetadataFormatNames,
				extraImageMetadataFormatClassNames, Collections
						.singletonList("JP2ECW"));

		if (LOGGER.isLoggable(Level.FINE))
			LOGGER.fine("JP2GDALEcwImageReaderSpi Constructor");
	}

	/**
	 * This method checks if the provided input can be decoded from this SPI
	 */
	public boolean canDecodeInput(Object input) throws IOException {
		return super.canDecodeInput(input);
	}

	/**
	 * Returns an instance of the JP2GDALEcwImageReader
	 * 
	 * @see javax.imageio.spi.ImageReaderSpi#createReaderInstance(java.lang.Object)
	 */
	public ImageReader createReaderInstance(Object source) throws IOException {
		return new JP2GDALEcwImageReader(this);
	}

	/**
	 * @see javax.imageio.spi.IIOServiceProvider#getDescription(java.util.Locale)
	 */
	public String getDescription(Locale locale) {
		return new StringBuffer("JP2K Image Reader, version ").append(version)
				.toString();
	}

}
