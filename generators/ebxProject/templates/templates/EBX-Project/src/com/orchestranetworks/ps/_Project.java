package com.orchestranetworks.ps;

import com.onwbp.adaptation.*;
<% if (presalesToolbox) { %>import com.orchestranetworks.presales.toolbox.repository.*;<% } %>
<% if (!presalesToolbox) { %>import com.orchestranetworks.instance.*;<% } %>

public final class Project
{
	public static class Entities
	{
		public static class Entity
		{
			/**
			 * Example of GoogleMaps usage from the PresalesToolbox
			 *
			public static GoogleMapsAddressFieldMapping getMapping()
			{
				GoogleMapsAddressFieldMapping mapping = new GoogleMapsAddressFieldMapping();
				mapping.setCityPath(Path.to.City);
				return mapping;
			}
			*/
		}
	}

	public static enum ReferenceDataSet
	{
		Example("ExampleDataSpaceName", "ExampleDataSetName");

		private final AdaptationHome dataSpace;
		private final Adaptation dataSet;

		private ReferenceDataSet(final String pDataSpaceName, final String pDataSetName)
		{
			<% if (presalesToolbox) { %>
			this.dataSpace = RepositoryUtils.getDataSpace(pDataSpaceName);
			this.dataSet = RepositoryUtils.getDataSet(pDataSpaceName, pDataSetName);
			<% } %>
			<% if (!presalesToolbox) { %>
			this.dataSpace = Repository.getDefault().lookupHome(HomeKey.forBranchName(pDataSpaceName));
			if (this.dataSpace != null)
			{
				this.dataSet = this.dataSpace.findAdaptationOrNull(AdaptationName.forName(pDataSetName));
			}
			else
			{
				this.dataSet = null;
			}

			/**
			* Using the PresalesToolbox allows easier access
			*
			* this.dataSpace = RepositoryUtils.getDataSpace(pDataSpaceName);
			* this.dataSet = RepositoryUtils.getDataSet(pDataSpaceName, pDataSetName);
			*/
			<% } %>
		}

		public Adaptation getDataSet()
		{
			return this.dataSet;
		}

		public AdaptationHome getDataSpace()
		{
			return this.dataSpace;
		}

	}

	public static enum Role
	{
		Example("example");

		private final String value;

		private Role(final String pValue)
		{
			this.value = pValue;
		}

		public String getValue()
		{
			return this.value;
		}
	}

	public static enum SchemaInformation
	{
		Example("example");

		private final String value;

		private SchemaInformation(final String pValue)
		{
			this.value = pValue;
		}

		public String getValue()
		{
			return this.value;
		}
	}

	public static enum TrackingInfo
	{
		Example("example");

		private final String value;

		private TrackingInfo(final String pValue)
		{
			this.value = pValue;
		}

		public String getValue()
		{
			return this.value;
		}
	}

	public static class Workflows
	{
		public static class Creation
		{
			/**
			 *
			public static final String PUBLICATION_NAME = "Creation";
			public static final String DATA_CONTEXT_INITIAL_DATASPACE = "initialDataSpace";
			public static final String DATA_CONTEXT_DATASPACE = "dataSpace";
			public static final String DATA_CONTEXT_DATASET = "dataSet";
			public static final String DATA_CONTEXT_TABLE_XPATH = "tableXpath";
			public static final String DATA_CONTEXT_RECORD_XPATH = "recordXpath";

			public static Adaptation getRecord(final DataContext pContext)
			{
				String dataSpaceName = pContext.getVariableString(Creation.DATA_CONTEXT_DATASPACE);
				String dataSetName = pContext.getVariableString(Creation.DATA_CONTEXT_DATASET);
				String tableXPath = pContext.getVariableString(Creation.DATA_CONTEXT_TABLE_XPATH);
				String recordXPath = pContext.getVariableString(Creation.DATA_CONTEXT_RECORD_XPATH);

				// RepositoryUtils is part of the PresalesToolbox
				return RepositoryUtils
					.getRecord(dataSpaceName, dataSetName, tableXPath, recordXPath);
			}
			*/
		}
	}

	private Project()
	{
	}
}
