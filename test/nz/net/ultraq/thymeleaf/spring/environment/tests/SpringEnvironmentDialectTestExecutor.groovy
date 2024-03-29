/* 
 * Copyright 2019, Emanuel Rabina (http://www.ultraq.net.nz/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nz.net.ultraq.thymeleaf.spring.environment.tests

import nz.net.ultraq.thymeleaf.spring.environment.SpringEnvironmentDialect
import nz.net.ultraq.thymeleaf.testing.junit.JUnitTestExecutorAll

import org.thymeleaf.dialect.IDialect
import org.thymeleaf.spring5.dialect.SpringStandardDialect
import org.thymeleaf.testing.templateengine.context.IProcessingContextBuilder
import org.thymeleaf.testing.templateengine.spring5.context.web.SpringMVCWebProcessingContextBuilder

/**
 * A test executor for all of the Thymeleaf test files.
 * 
 * @author Emanuel Rabina
 */
class SpringEnvironmentDialectTestExecutor extends JUnitTestExecutorAll {

	final List<? extends IDialect> testDialects = [
		new SpringStandardDialect(),
	  new SpringEnvironmentDialect()
	]

	final IProcessingContextBuilder testProcessingContextBuilder = new SpringMVCWebProcessingContextBuilder(
		applicationContextConfigLocation: 'classpath:application-context-development.xml'
	)
}
