/*
 * Copyright 2013 International Business Machines Corp.
 * 
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership. Licensed under the Apache License, 
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.jbatch.tck.artifacts.specialized;

import com.sun.ts.lib.harness.*;
import com.sun.ts.lib.util.TestUtil;

import java.util.Properties;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.inject.Inject;

@javax.inject.Named("stepLevelPropertiesShouldNotBeAvailableThroughJobContextBatchlet")
public class StepLevelPropertiesShouldNotBeAvailableThroughJobContextBatchlet  extends AbstractBatchlet{
    @Inject
	JobContext JobCtx;
    
    @Inject
    StepContext StepCtx;
    
	public static String GOOD_EXIT_STATUS = "VERY GOOD INVOCATION"; 

	@Override
	public String process() throws Exception {
		
		// frozz is a step level properties, it should not be avail in the job context
		Properties properties = JobCtx.getProperties();
		// should be null
		String frozz = properties.getProperty("frozz");

		// the exit status should be COMPLETED since frozz must be null
		JobCtx.setExitStatus(frozz);

		return GOOD_EXIT_STATUS;
	}
}
