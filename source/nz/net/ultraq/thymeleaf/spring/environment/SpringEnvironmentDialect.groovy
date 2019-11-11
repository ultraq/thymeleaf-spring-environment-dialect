/* 
 * Copyright 2017, Emanuel Rabina (http://www.ultraq.net.nz/)
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

package nz.net.ultraq.thymeleaf.spring.environment

import nz.net.ultraq.thymeleaf.spring.environment.processors.IfProcessor
import nz.net.ultraq.thymeleaf.spring.environment.processors.UnlessProcessor

import org.thymeleaf.dialect.AbstractProcessorDialect
import org.thymeleaf.processor.IProcessor
import org.thymeleaf.standard.StandardDialect
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor
import org.thymeleaf.templatemode.TemplateMode

/**
 * Thymeleaf dialect for simple template rendering based on the current Spring
 * environment.
 * 
 * @author Emanuel Rabina
 */
class SpringEnvironmentDialect extends AbstractProcessorDialect {

	static final String NAMESPACE = 'http://www.ultraq.net.nz/thymeleaf/spring-environment'
	static final String NAME = 'Environment'
	static final String PREFIX = 'env'

	/**
	 * Constructor, initialize this dialect with the "Environment" name.
	 */
	SpringEnvironmentDialect() {

		super(NAME, PREFIX, StandardDialect.PROCESSOR_PRECEDENCE)
	}

	/**
	 * Return the environment dialect's processors.
	 * 
	 * @param dialectPrefix
	 * @return All of the processors for HTML template modes.
	 */
	@Override
	Set<IProcessor> getProcessors(String dialectPrefix) {

		return [
			new StandardXmlNsTagProcessor(TemplateMode.HTML, dialectPrefix),
			new IfProcessor(dialectPrefix),
			new UnlessProcessor(dialectPrefix)
		]
	}
}
