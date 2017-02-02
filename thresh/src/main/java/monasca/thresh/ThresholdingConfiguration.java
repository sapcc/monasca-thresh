/*
 * Copyright (c) 2014 Hewlett-Packard Development Company, L.P.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package monasca.thresh;

import monasca.common.configuration.KafkaProducerConfiguration;
import monasca.thresh.infrastructure.thresholding.DataSourceFactory;
import monasca.thresh.utils.StatsdConfig;

import java.io.Serializable;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Thresholding configuration.
 */
public class ThresholdingConfiguration implements Serializable {
  private static final long serialVersionUID = 8939559160479071931L;

  /** Total number of workers processes across the cluster. */
  @NotNull public Integer numWorkerProcesses = 12;
  /** Total number of acker threads across the cluster. */
  @NotNull public Integer numAckerThreads = 12;

  @NotNull public Integer metricSpoutThreads = 6;
  @NotNull public Integer metricSpoutTasks = 6;

  @NotNull public Integer eventSpoutThreads = 3;
  @NotNull public Integer eventSpoutTasks = 3;

  @NotNull public Integer eventBoltThreads = 3;
  @NotNull public Integer eventBoltTasks = 3;

  @NotNull public Integer filteringBoltThreads = 6;
  @NotNull public Integer filteringBoltTasks = 15;

  @NotNull public Integer alarmCreationBoltThreads = 4;
  @NotNull public Integer alarmCreationBoltTasks = 4;

  @NotNull public Integer aggregationBoltThreads = 12;
  @NotNull public Integer aggregationBoltTasks = 30;

  @NotNull public Integer thresholdingBoltThreads = 6;
  @NotNull public Integer thresholdingBoltTasks = 15;

  @NotNull public Integer alarmDelay = 30;

  @NotNull public Boolean keepAlarmDefs = Boolean.TRUE;

  /** Namespaces for which metrics are received sporadically. */
  @NotNull public Set<String> sporadicMetricNamespaces;

  /** Configuration for the spout that receives metrics from Kafka. */
  @Valid @NotNull public MetricSpoutConfig metricSpoutConfig;
  /** Configuration for the spout that receives events from Kafka. */
  @Valid @NotNull public EventSpoutConfig eventSpoutConfig;

  /** Configuration for publishing to the Kafka. */
  @Valid @NotNull public KafkaProducerConfiguration kafkaProducerConfig = new KafkaProducerConfiguration();

  /** Database configuration. */
  @Valid @NotNull public DataSourceFactory database = new DataSourceFactory();

  /** StatsD configuration. */
  @Valid @NotNull public StatsdConfig statsdConfig = new StatsdConfig();

}
