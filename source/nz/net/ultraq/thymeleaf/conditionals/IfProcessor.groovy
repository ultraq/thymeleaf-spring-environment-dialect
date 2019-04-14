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

package nz.net.ultraq.thymeleaf.conditionals

import org.thymeleaf.context.ITemplateContext
import org.thymeleaf.engine.AttributeName
import org.thymeleaf.model.IProcessableElementTag
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor
import org.thymeleaf.processor.element.IElementTagStructureHandler
import org.thymeleaf.standard.processor.StandardIfTagProcessor
import org.thymeleaf.templatemode.TemplateMode
import static org.thymeleaf.spring5.expression.ThymeleafEvaluationContext.THYMELEAF_EVALUATION_CONTEXT_CONTEXT_VARIABLE_NAME

/**
 * Processor for the {@code env:if} attribute, renders any child markup if the
 * environment passed to this processor matches the current environment.
 * 
 * @author Emanuel Rabina
 */
class IfProcessor extends AbstractAttributeTagProcessor {

	static final String NAME = 'if'

	/**
	 * Constructor, set this processor to work on the {@code env:if} attribute.
	 * 
	 * @param dialectPrefix
	 */
	IfProcessor(String dialectPrefix) {

		super(TemplateMode.HTML, dialectPrefix, null, false, NAME, true, StandardIfTagProcessor.PRECEDENCE + 1, true)
	}

	/**
	 * Evaluates the environment name given to this processor, rendering the child
	 * markup if the current environment matches.
	 * 
	 * @param context
	 * @param tag
	 * @param attributeName
	 * @param attributeValue
	 * @param structureHandler
	 */
	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
		AttributeName attributeName, String attributeValue, IElementTagStructureHandler structureHandler) {

		def thymeleafEvaluationContext = context.getVariable(THYMELEAF_EVALUATION_CONTEXT_CONTEXT_VARIABLE_NAME)
		def environment = thymeleafEvaluationContext.beanResolver.resolve(thymeleafEvaluationContext, 'environment')
		def intendedEnvironment = attributeValue

		if (!environment.activeProfiles.contains(intendedEnvironment)) {
			structureHandler.removeElement()
		}
	}
}
