/**
 * 
 */
package snippet;

/**
 * @author rampraja1
 * @date 2019-Sep-14 1:06:54 PM 
 */
public class Snippet {
	<?xml version="1.0" encoding="UTF-8"?>
	<configuration>
		<!--<include resource="org/springframework/boot/logging/logback/base.xml"/> -->
		<property name="LOG_PATH" value="notification-logs" />
	
		<appender name="STDOUT"
			class="ch.qos.logback.core.ConsoleAppender">
			<encoder>
				<pattern>
					%d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread])
					%highlight(%-5level) %logger.%M -
					%msg%n
				</pattern>
			</encoder>
		</appender>
	
		<appender name="SAVE-TO-FILE"
			class="ch.qos.logback.core.FileAppender">
			<file>${LOG_PATH}/notification-logs.log</file>
			<encoder
				class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
				<Pattern>
					%d{dd-MM-yyyy HH:mm:ss.SSS} [%thread] %-5level
					%logger{36}.%M - %msg%n
				</Pattern>
			</encoder>
		</appender>
	
		<appender name="SAVE-TO-FILE"
			class="ch.qos.logback.core.rolling.RollingFileAppender">
			<file>${LOG_PATH}/notification-logs_.log</file>
			<encoder
				class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
				<Pattern>
					%d{dd-MM-yyyy HH:mm:ss.SSS} [%thread] %-5level
					%logger{36}.%M - %msg%n
				</Pattern>
			</encoder>
	
			<!-- Comment out rolling policies to test how the remaining one works -->
	
			<rollingPolicy
				class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
				<!-- rollover daily -->
				<fileNamePattern>
					${LOG_PATH}/archived/notification-logs_.%d{dd-MM-yyyy}.log
				</fileNamePattern>
				<maxHistory>10</maxHistory>
				<totalSizeCap>100MB</totalSizeCap>
			</rollingPolicy>
	
			<rollingPolicy
				class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
				<!-- rollover daily & on size -->
				<maxFileSize>10MB</maxFileSize>
				<fileNamePattern>
					${LOG_PATH}/archived/notification-logs_%d{dd-MM-yyyy}_%i.log
				</fileNamePattern>
				<maxHistory>10</maxHistory>
				<totalSizeCap>100MB</totalSizeCap>
			</rollingPolicy>
	
			<rollingPolicy
				class="ch.qos.logback.core.rolling.FixedWindowRollingPolicy">
				<fileNamePattern>
					${LOG_PATH}/notification-logs_%i.log
				</fileNamePattern>
				<minIndex>2</minIndex>
				<maxIndex>3</maxIndex>
			</rollingPolicy>
	
			<triggeringPolicy
				class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
				<!-- rollover on size -->
				<maxFileSize>1KB</maxFileSize>
			</triggeringPolicy>
	
		</appender>
	
		<!--<root level="debug"> -->
		<root level="OFF">
			<appender-ref ref="STDOUT" />
			<appender-ref ref="SAVE-TO-FILE" />
		</root>
	
		<logger name="com.online.trading" additivity="false"
			level="debug">
			<appender-ref ref="STDOUT" />
			<!--<appender-ref ref="SAVE-TO-FILE"/> -->
		</logger>
	
		<!--<logger name="org.springframework.boot.SpringApplication" level="debug"> -->
		<!--<appender-ref ref="STDOUT" /> -->
		<!--</logger> -->
	</configuration>
}

