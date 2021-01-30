/* 
 * Copyright 2021, Emanuel Rabina (http://www.ultraq.net.nz/)
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

package nz.net.ultraq.thymeleaf.spring.environment.extensions

import org.springframework.web.context.support.StandardServletEnvironment

/**
 * Extensions to Spring's environment object.
 * 
 * @author Emanuel Rabina
 */
class StandardServletEnvironmentExtensions {

	/**
	 * Return whether or not we're in the development environment.
	 * 
	 * @param self
	 * @return
	 */
	static boolean isDevelopment(StandardServletEnvironment self) {

		return self.is('development')
	}

	/**
	 * Return whether or not we're in the specified environment.
	 * 
	 * @param self
	 * @param environment
	 * @return
	 */
	static boolean is(StandardServletEnvironment self, String environment) {

		return self.activeProfiles.contains(environment)
	}
}
