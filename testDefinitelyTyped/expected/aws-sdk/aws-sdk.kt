// OUT:
// WRONG
package aws-sdk

module
// WRONG module name
public object aws-sdk {
    public var config: ClientConfig = noImpl
    public fun Config(json: Any): Unit = noImpl
    public class Credentials(accessKeyId: String, secretAccessKey: String, sessionToken: String? = null) {
        public var accessKeyId: String = noImpl
    }
    public trait ClientConfig {
        public var credentials: Credentials
        public var region: String
    }
    public class SQS(options: Any? = null) {
        public var client: Sqs.Client = noImpl
    }
    public class SES(options: Any? = null) {
        public var client: Ses.Client = noImpl
    }
    public class SNS(options: Any? = null) {
        public var client: Sns.Client = noImpl
    }
    public class SimpleWorkflow(options: Any? = null) {
        public var client: Swf.Client = noImpl
    }
    public class S3(options: Any? = null) {
        public var client: s3.Client = noImpl
    }
    module
    public object Sqs {
        public trait Client {
            public var config: ClientConfig
            public fun sendMessage(params: SendMessageRequest, callback: (err: Any, data: SendMessageResult) -> Unit): Unit
            public fun sendMessageBatch(params: SendMessageBatchRequest, callback: (err: Any, data: SendMessageBatchResult) -> Unit): Unit
            public fun receiveMessage(params: ReceiveMessageRequest, callback: (err: Any, data: ReceiveMessageResult) -> Unit): Unit
            public fun deleteMessage(params: DeleteMessageRequest, callback: (err: Any, data: Any) -> Unit): Unit
            public fun deleteMessageBatch(params: DeleteMessageBatchRequest, callback: (err: Any, data: DeleteMessageBatchResult) -> Unit): Unit
            public fun createQueue(params: CreateQueueRequest, callback: (err: Any, data: CreateQueueResult) -> Unit): Unit
            public fun deleteQueue(params: DeleteQueueRequest, callback: (err: Any, data: Any) -> Unit): Unit
        }
        public trait SendMessageRequest {
            public var QueueUrl: String?
            public var MessageBody: String?
            public var DelaySeconds: Number?
        }
        public trait ReceiveMessageRequest {
            public var QueueUrl: String?
            public var MaxNumberOfMessages: Number?
            public var VisibilityTimeout: Number?
            public var AttributeNames: Array<String>?
        }
        public trait DeleteMessageBatchRequest {
            public var QueueUrl: String?
            public var Entries: Array<DeleteMessageBatchRequestEntry>?
        }
        public trait DeleteMessageBatchRequestEntry {
            public var Id: String
            public var ReceiptHandle: String
        }
        public trait DeleteMessageRequest {
            public var QueueUrl: String?
            public var ReceiptHandle: String?
        }
        public class Attribute {
            public var Name: String = noImpl
            public var Value: String = noImpl
        }
        public trait SendMessageBatchRequest {
            public var QueueUrl: String?
            public var Entries: Array<SendMessageBatchRequestEntry>?
        }
        public class SendMessageBatchRequestEntry {
            public var Id: String = noImpl
            public var MessageBody: String = noImpl
            public var DelaySeconds: Number = noImpl
        }
        public trait CreateQueueRequest {
            public var QueueName: String?
            public var DefaultVisibilityTimeout: Number?
            public var DelaySeconds: Number?
            public var Attributes: Array<Attribute>?
        }
        public trait DeleteQueueRequest {
            public var QueueUrl: String?
        }
        public class SendMessageResult {
            public var MessageId: String = noImpl
            public var MD5OfMessageBody: String = noImpl
        }
        public class ReceiveMessageResult {
            public var Messages: Array<Message> = noImpl
        }
        public class Message {
            public var MessageId: String = noImpl
            public var ReceiptHandle: String = noImpl
            public var MD5OfBody: String = noImpl
            public var Body: String = noImpl
            public var Attributes: Array<Attribute> = noImpl
        }
        public class DeleteMessageBatchResult {
            public var Successful: Array<DeleteMessageBatchResultEntry> = noImpl
            public var Failed: Array<BatchResultErrorEntry> = noImpl
        }
        public class DeleteMessageBatchResultEntry {
            public var Id: String = noImpl
        }
        public class BatchResultErrorEntry {
            public var Id: String = noImpl
            public var Code: String = noImpl
            public var Message: String = noImpl
            public var SenderFault: String = noImpl
        }
        public class SendMessageBatchResult {
            public var Successful: Array<SendMessageBatchResultEntry> = noImpl
            public var Failed: Array<BatchResultErrorEntry> = noImpl
        }
        public class SendMessageBatchResultEntry {
            public var Id: String = noImpl
            public var MessageId: String = noImpl
            public var MD5OfMessageBody: String = noImpl
        }
        public class CreateQueueResult {
            public var QueueUrl: String = noImpl
        }
    }
    module
    public object Ses {
        public trait Client {
            public var config: ClientConfig
            public fun sendEmail(params: Any, callback: (err: Any, data: SendEmailResult) -> Unit): Unit
        }
        public trait SendEmailRequest {
            public var Source: String
            public var Destination: Destination
            public var Message: Message
            public var ReplyToAddresses: Array<String>
            public var ReturnPath: String
        }
        public class Destination {
            public var ToAddresses: Array<String> = noImpl
            public var CcAddresses: Array<String> = noImpl
            public var BccAddresses: Array<String> = noImpl
        }
        public class Message {
            public var Subject: Content = noImpl
            public var Body: Body = noImpl
        }
        public class Content {
            public var Data: String = noImpl
            public var Charset: String = noImpl
        }
        public class Body {
            public var Text: Content = noImpl
            public var Html: Content = noImpl
        }
        public class SendEmailResult {
            public var MessageId: String = noImpl
        }
    }
    module
    public object Swf {
        public class Client {
            public var config: ClientConfig = noImpl
            public fun countClosedWorkflowExecutions(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun countOpenWorkflowExecutions(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun countPendingActivityTasks(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun countPendingDecisionTasks(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun deprecateActivityType(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun deprecateDomain(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun deprecateWorkflowType(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun describeActivityType(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun describeDomain(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun describeWorkflowExecution(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun describeWorkflowType(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun getWorkflowExecutionHistory(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun listActivityTypes(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun listClosedWorkflowExecutions(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun listDomains(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun listOpenWorkflowExecutions(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun listWorkflowTypes(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun pollForActivityTask(params: Any, callback: (err: Any, data: ActivityTask) -> Unit): Unit = noImpl
            public fun pollForDecisionTask(params: Any, callback: (err: Any, data: DecisionTask) -> Unit): Unit = noImpl
            public fun recordActivityTaskHeartbeat(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun registerActivityType(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun registerDomain(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun registerWorkflowType(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun requestCancelWorkflowExecution(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun respondActivityTaskCanceled(params: RespondActivityTaskCanceledRequest, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun respondActivityTaskCompleted(params: RespondActivityTaskCompletedRequest, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun respondActivityTaskFailed(params: RespondActivityTaskFailedRequest, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun respondDecisionTaskCompleted(params: RespondDecisionTaskCompletedRequest, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun signalWorkflowExecution(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
            public fun startWorkflowExecution(params: Any, callback: (err: Any, data: StartWorkflowExecutionResult) -> Unit): Unit = noImpl
            public fun terminateWorkflowExecution(params: Any, callback: (err: Any, data: Any) -> Unit): Unit = noImpl
        }
        public trait PollForActivityTaskRequest {
            public var domain: String?
            public var taskList: TaskList?
            public var identity: String?
        }
        public trait TaskList {
            public var name: String?
        }
        public trait PollForDecisionTaskRequest {
            public var domain: String?
            public var taskList: TaskList?
            public var identity: String?
            public var nextPageToken: String?
            public var maximumPageSize: Number?
            public var reverseOrder: Boolean?
        }
        public trait StartWorkflowExecutionRequest {
            public var domain: String?
            public var workflowId: String?
            public var workflowType: WorkflowType?
            public var taskList: TaskList?
            public var input: String?
            public var executionStartToCloseTimeout: String?
            public var tagList: Array<String>?
            public var taskStartToCloseTimeout: String?
            public var childPolicy: String?
        }
        public trait WorkflowType {
            public var name: String?
            public var version: String?
        }
        public trait RespondDecisionTaskCompletedRequest {
            public var taskToken: String?
            public var decisions: Array<Decision>?
            public var executionContext: String?
        }
        public trait Decision {
            public var decisionType: String?
            public var scheduleActivityTaskDecisionAttributes: ScheduleActivityTaskDecisionAttributes?
            public var requestCancelActivityTaskDecisionAttributes: RequestCancelActivityTaskDecisionAttributes?
            public var completeWorkflowExecutionDecisionAttributes: CompleteWorkflowExecutionDecisionAttributes?
            public var failWorkflowExecutionDecisionAttributes: FailWorkflowExecutionDecisionAttributes?
            public var cancelWorkflowExecutionDecisionAttributes: CancelWorkflowExecutionDecisionAttributes?
            public var continueAsNewWorkflowExecutionDecisionAttributes: ContinueAsNewWorkflowExecutionDecisionAttributes?
            public var recordMarkerDecisionAttributes: RecordMarkerDecisionAttributes?
            public var startTimerDecisionAttributes: StartTimerDecisionAttributes?
            public var cancelTimerDecisionAttributes: CancelTimerDecisionAttributes?
            public var signalExternalWorkflowExecutionDecisionAttributes: SignalExternalWorkflowExecutionDecisionAttributes?
            public var requestCancelExternalWorkflowExecutionDecisionAttributes: RequestCancelExternalWorkflowExecutionDecisionAttributes?
            public var startChildWorkflowExecutionDecisionAttributes: StartChildWorkflowExecutionDecisionAttributes?
        }
        public trait ScheduleActivityTaskDecisionAttributes {
            public var activityType: ActivityType?
            public var activityId: String?
            public var control: String?
            public var input: String?
            public var scheduleToCloseTimeout: String?
            public var taskList: TaskList?
            public var scheduleToStartTimeout: String?
            public var startToCloseTimeout: String?
            public var heartbeatTimeout: String?
        }
        public trait ActivityType {
            public var name: String?
            public var version: String?
        }
        public trait RequestCancelActivityTaskDecisionAttributes {
            public var activityId: String?
        }
        public trait CompleteWorkflowExecutionDecisionAttributes {
            public var result: String?
        }
        public trait FailWorkflowExecutionDecisionAttributes {
            public var reason: String?
            public var details: String?
        }
        public trait CancelWorkflowExecutionDecisionAttributes {
            public var details: String?
        }
        public trait ContinueAsNewWorkflowExecutionDecisionAttributes {
            public var input: String?
            public var executionStartToCloseTimeout: String?
            public var taskList: TaskList?
            public var taskStartToCloseTimeout: String?
            public var childPolicy: String?
            public var tagList: Array<String>?
            public var workflowTypeVersion: String?
        }
        public trait RecordMarkerDecisionAttributes {
            public var markerName: String?
            public var details: String?
        }
        public trait StartTimerDecisionAttributes {
            public var timerId: String?
            public var control: String?
            public var startToFireTimeout: String?
        }
        public trait CancelTimerDecisionAttributes {
            public var timerId: String?
        }
        public trait SignalExternalWorkflowExecutionDecisionAttributes {
            public var workflowId: String?
            public var runId: String?
            public var signalName: String?
            public var input: String?
            public var control: String?
        }
        public trait RequestCancelExternalWorkflowExecutionDecisionAttributes {
            public var workflowId: String?
            public var runId: String?
            public var control: String?
        }
        public trait StartChildWorkflowExecutionDecisionAttributes {
            public var workflowType: WorkflowType?
            public var workflowId: String?
            public var control: String?
            public var input: String?
            public var executionStartToCloseTimeout: String?
            public var taskList: TaskList?
            public var taskStartToCloseTimeout: String?
            public var childPolicy: String?
            public var tagList: Array<String>?
        }
        public trait RespondActivityTaskCompletedRequest {
            public var taskToken: String?
            public var result: String?
        }
        public trait RespondActivityTaskFailedRequest {
            public var taskToken: String?
            public var reason: String?
            public var details: String?
        }
        public trait RespondActivityTaskCanceledRequest {
            public var taskToken: String?
            public var details: String?
        }
        public trait DecisionTask {
            public var taskToken: String?
            public var startedEventId: Number?
            public var workflowExecution: WorkflowExecution?
            public var workflowType: WorkflowType?
            public var events: Array<HistoryEvent>?
            public var nextPageToken: String?
            public var previousStartedEventId: Number?
        }
        public trait WorkflowExecution {
            public var workflowId: String?
            public var runId: String?
        }
        public trait HistoryEvent {
            public var eventTimestamp: Any?
            public var eventType: String?
            public var eventId: Number?
            public var workflowExecutionStartedEventAttributes: WorkflowExecutionStartedEventAttributes?
            public var workflowExecutionCompletedEventAttributes: WorkflowExecutionCompletedEventAttributes?
            public var completeWorkflowExecutionFailedEventAttributes: CompleteWorkflowExecutionFailedEventAttributes?
            public var workflowExecutionFailedEventAttributes: WorkflowExecutionFailedEventAttributes?
            public var failWorkflowExecutionFailedEventAttributes: FailWorkflowExecutionFailedEventAttributes?
            public var workflowExecutionTimedOutEventAttributes: WorkflowExecutionTimedOutEventAttributes?
            public var workflowExecutionCanceledEventAttributes: WorkflowExecutionCanceledEventAttributes?
            public var cancelWorkflowExecutionFailedEventAttributes: CancelWorkflowExecutionFailedEventAttributes?
            public var workflowExecutionContinuedAsNewEventAttributes: WorkflowExecutionContinuedAsNewEventAttributes?
            public var continueAsNewWorkflowExecutionFailedEventAttributes: ContinueAsNewWorkflowExecutionFailedEventAttributes?
            public var workflowExecutionTerminatedEventAttributes: WorkflowExecutionTerminatedEventAttributes?
            public var workflowExecutionCancelRequestedEventAttributes: WorkflowExecutionCancelRequestedEventAttributes?
            public var decisionTaskScheduledEventAttributes: DecisionTaskScheduledEventAttributes?
            public var decisionTaskStartedEventAttributes: DecisionTaskStartedEventAttributes?
            public var decisionTaskCompletedEventAttributes: DecisionTaskCompletedEventAttributes?
            public var decisionTaskTimedOutEventAttributes: DecisionTaskTimedOutEventAttributes?
            public var activityTaskScheduledEventAttributes: ActivityTaskScheduledEventAttributes?
            public var activityTaskStartedEventAttributes: ActivityTaskStartedEventAttributes?
            public var activityTaskCompletedEventAttributes: ActivityTaskCompletedEventAttributes?
            public var activityTaskFailedEventAttributes: ActivityTaskFailedEventAttributes?
            public var activityTaskTimedOutEventAttributes: ActivityTaskTimedOutEventAttributes?
            public var activityTaskCanceledEventAttributes: ActivityTaskCanceledEventAttributes?
            public var activityTaskCancelRequestedEventAttributes: ActivityTaskCancelRequestedEventAttributes?
            public var workflowExecutionSignaledEventAttributes: WorkflowExecutionSignaledEventAttributes?
            public var markerRecordedEventAttributes: MarkerRecordedEventAttributes?
            public var timerStartedEventAttributes: TimerStartedEventAttributes?
            public var timerFiredEventAttributes: TimerFiredEventAttributes?
            public var timerCanceledEventAttributes: TimerCanceledEventAttributes?
            public var startChildWorkflowExecutionInitiatedEventAttributes: StartChildWorkflowExecutionInitiatedEventAttributes?
            public var childWorkflowExecutionStartedEventAttributes: ChildWorkflowExecutionStartedEventAttributes?
            public var childWorkflowExecutionCompletedEventAttributes: ChildWorkflowExecutionCompletedEventAttributes?
            public var childWorkflowExecutionFailedEventAttributes: ChildWorkflowExecutionFailedEventAttributes?
            public var childWorkflowExecutionTimedOutEventAttributes: ChildWorkflowExecutionTimedOutEventAttributes?
            public var childWorkflowExecutionCanceledEventAttributes: ChildWorkflowExecutionCanceledEventAttributes?
            public var childWorkflowExecutionTerminatedEventAttributes: ChildWorkflowExecutionTerminatedEventAttributes?
            public var signalExternalWorkflowExecutionInitiatedEventAttributes: SignalExternalWorkflowExecutionInitiatedEventAttributes?
            public var externalWorkflowExecutionSignaledEventAttributes: ExternalWorkflowExecutionSignaledEventAttributes?
            public var signalExternalWorkflowExecutionFailedEventAttributes: SignalExternalWorkflowExecutionFailedEventAttributes?
            public var externalWorkflowExecutionCancelRequestedEventAttributes: ExternalWorkflowExecutionCancelRequestedEventAttributes?
            public var requestCancelExternalWorkflowExecutionInitiatedEventAttributes: RequestCancelExternalWorkflowExecutionInitiatedEventAttributes?
            public var requestCancelExternalWorkflowExecutionFailedEventAttributes: RequestCancelExternalWorkflowExecutionFailedEventAttributes?
            public var scheduleActivityTaskFailedEventAttributes: ScheduleActivityTaskFailedEventAttributes?
            public var requestCancelActivityTaskFailedEventAttributes: RequestCancelActivityTaskFailedEventAttributes?
            public var startTimerFailedEventAttributes: StartTimerFailedEventAttributes?
            public var cancelTimerFailedEventAttributes: CancelTimerFailedEventAttributes?
            public var startChildWorkflowExecutionFailedEventAttributes: StartChildWorkflowExecutionFailedEventAttributes?
        }
        public trait WorkflowExecutionStartedEventAttributes {
            public var input: String?
            public var executionStartToCloseTimeout: String?
            public var taskStartToCloseTimeout: String?
            public var childPolicy: String?
            public var taskList: TaskList?
            public var workflowType: WorkflowType?
            public var tagList: Array<String>?
            public var continuedExecutionRunId: String?
            public var parentWorkflowExecution: WorkflowExecution?
            public var parentInitiatedEventId: Number?
        }
        public trait WorkflowExecutionCompletedEventAttributes {
            public var result: String?
            public var decisionTaskCompletedEventId: Number?
        }
        public trait CompleteWorkflowExecutionFailedEventAttributes {
            public var cause: String?
            public var decisionTaskCompletedEventId: Number?
        }
        public trait WorkflowExecutionFailedEventAttributes {
            public var reason: String?
            public var details: String?
            public var decisionTaskCompletedEventId: Number?
        }
        public trait FailWorkflowExecutionFailedEventAttributes {
            public var cause: String?
            public var decisionTaskCompletedEventId: Number?
        }
        public trait WorkflowExecutionTimedOutEventAttributes {
            public var timeoutType: String?
            public var childPolicy: String?
        }
        public trait WorkflowExecutionCanceledEventAttributes {
            public var details: String?
            public var decisionTaskCompletedEventId: Number?
        }
        public trait CancelWorkflowExecutionFailedEventAttributes {
            public var cause: String?
            public var decisionTaskCompletedEventId: Number?
        }
        public trait WorkflowExecutionContinuedAsNewEventAttributes {
            public var input: String?
            public var decisionTaskCompletedEventId: Number?
            public var newExecutionRunId: String?
            public var executionStartToCloseTimeout: String?
            public var taskList: TaskList?
            public var taskStartToCloseTimeout: String?
            public var childPolicy: String?
            public var tagList: Array<String>?
            public var workflowType: WorkflowType?
        }
        public trait ContinueAsNewWorkflowExecutionFailedEventAttributes {
            public var cause: String?
            public var decisionTaskCompletedEventId: Number?
        }
        public trait WorkflowExecutionTerminatedEventAttributes {
            public var reason: String?
            public var details: String?
            public var childPolicy: String?
            public var cause: String?
        }
        public trait WorkflowExecutionCancelRequestedEventAttributes {
            public var externalWorkflowExecution: WorkflowExecution?
            public var externalInitiatedEventId: Number?
            public var cause: String?
        }
        public trait DecisionTaskScheduledEventAttributes {
            public var taskList: TaskList?
            public var startToCloseTimeout: String?
        }
        public trait DecisionTaskStartedEventAttributes {
            public var identity: String?
            public var scheduledEventId: Number?
        }
        public trait DecisionTaskCompletedEventAttributes {
            public var executionContext: String?
            public var scheduledEventId: Number?
            public var startedEventId: Number?
        }
        public trait DecisionTaskTimedOutEventAttributes {
            public var timeoutType: String?
            public var scheduledEventId: Number?
            public var startedEventId: Number?
        }
        public trait ActivityTaskScheduledEventAttributes {
            public var activityType: ActivityType?
            public var activityId: String?
            public var input: String?
            public var control: String?
            public var scheduleToStartTimeout: String?
            public var scheduleToCloseTimeout: String?
            public var startToCloseTimeout: String?
            public var taskList: TaskList?
            public var decisionTaskCompletedEventId: Number?
            public var heartbeatTimeout: String?
        }
        public trait ActivityTaskStartedEventAttributes {
            public var identity: String?
            public var scheduledEventId: Number?
        }
        public trait ActivityTaskCompletedEventAttributes {
            public var result: String?
            public var scheduledEventId: Number?
            public var startedEventId: Number?
        }
        public trait ActivityTaskFailedEventAttributes {
            public var reason: String?
            public var details: String?
            public var scheduledEventId: Number?
            public var startedEventId: Number?
        }
        public trait ActivityTaskTimedOutEventAttributes {
            public var timeoutType: String?
            public var scheduledEventId: Number?
            public var startedEventId: Number?
            public var details: String?
        }
        public trait ActivityTaskCanceledEventAttributes {
            public var details: String?
            public var scheduledEventId: Number?
            public var startedEventId: Number?
            public var latestCancelRequestedEventId: Number?
        }
        public trait ActivityTaskCancelRequestedEventAttributes {
            public var decisionTaskCompletedEventId: Number?
            public var activityId: String?
        }
        public trait WorkflowExecutionSignaledEventAttributes {
            public var signalName: String?
            public var input: String?
            public var externalWorkflowExecution: WorkflowExecution?
            public var externalInitiatedEventId: Number?
        }
        public trait MarkerRecordedEventAttributes {
            public var markerName: String?
            public var details: String?
            public var decisionTaskCompletedEventId: Number?
        }
        public trait TimerStartedEventAttributes {
            public var timerId: String?
            public var control: String?
            public var startToFireTimeout: String?
            public var decisionTaskCompletedEventId: Number?
        }
        public trait TimerFiredEventAttributes {
            public var timerId: String?
            public var startedEventId: Number?
        }
        public trait TimerCanceledEventAttributes {
            public var timerId: String?
            public var startedEventId: Number?
            public var decisionTaskCompletedEventId: Number?
        }
        public trait StartChildWorkflowExecutionInitiatedEventAttributes {
            public var workflowId: String?
            public var workflowType: WorkflowType?
            public var control: String?
            public var input: String?
            public var executionStartToCloseTimeout: String?
            public var taskList: TaskList?
            public var decisionTaskCompletedEventId: Number?
            public var childPolicy: String?
            public var taskStartToCloseTimeout: String?
            public var tagList: Array<String>?
        }
        public trait ChildWorkflowExecutionStartedEventAttributes {
            public var workflowExecution: WorkflowExecution?
            public var workflowType: WorkflowType?
            public var initiatedEventId: Number?
        }
        public trait ChildWorkflowExecutionCompletedEventAttributes {
            public var workflowExecution: WorkflowExecution?
            public var workflowType: WorkflowType?
            public var result: String?
            public var initiatedEventId: Number?
            public var startedEventId: Number?
        }
        public trait ChildWorkflowExecutionFailedEventAttributes {
            public var workflowExecution: WorkflowExecution?
            public var workflowType: WorkflowType?
            public var reason: String?
            public var details: String?
            public var initiatedEventId: Number?
            public var startedEventId: Number?
        }
        public trait ChildWorkflowExecutionTimedOutEventAttributes {
            public var workflowExecution: WorkflowExecution?
            public var workflowType: WorkflowType?
            public var timeoutType: String?
            public var initiatedEventId: Number?
            public var startedEventId: Number?
        }
        public trait ChildWorkflowExecutionCanceledEventAttributes {
            public var workflowExecution: WorkflowExecution?
            public var workflowType: WorkflowType?
            public var details: String?
            public var initiatedEventId: Number?
            public var startedEventId: Number?
        }
        public trait ChildWorkflowExecutionTerminatedEventAttributes {
            public var workflowExecution: WorkflowExecution?
            public var workflowType: WorkflowType?
            public var initiatedEventId: Number?
            public var startedEventId: Number?
        }
        public trait SignalExternalWorkflowExecutionInitiatedEventAttributes {
            public var workflowId: String?
            public var runId: String?
            public var signalName: String?
            public var input: String?
            public var decisionTaskCompletedEventId: Number?
            public var control: String?
        }
        public trait ExternalWorkflowExecutionSignaledEventAttributes {
            public var workflowExecution: WorkflowExecution?
            public var initiatedEventId: Number?
        }
        public trait SignalExternalWorkflowExecutionFailedEventAttributes {
            public var workflowId: String?
            public var runId: String?
            public var cause: String?
            public var initiatedEventId: Number?
            public var decisionTaskCompletedEventId: Number?
            public var control: String?
        }
        public trait ExternalWorkflowExecutionCancelRequestedEventAttributes {
            public var workflowExecution: WorkflowExecution?
            public var initiatedEventId: Number?
        }
        public trait RequestCancelExternalWorkflowExecutionInitiatedEventAttributes {
            public var workflowId: String?
            public var runId: String?
            public var decisionTaskCompletedEventId: Number?
            public var control: String?
        }
        public trait RequestCancelExternalWorkflowExecutionFailedEventAttributes {
            public var workflowId: String?
            public var runId: String?
            public var cause: String?
            public var initiatedEventId: Number?
            public var decisionTaskCompletedEventId: Number?
            public var control: String?
        }
        public trait ScheduleActivityTaskFailedEventAttributes {
            public var activityType: ActivityType?
            public var activityId: String?
            public var cause: String?
            public var decisionTaskCompletedEventId: Number?
        }
        public trait RequestCancelActivityTaskFailedEventAttributes {
            public var activityId: String?
            public var cause: String?
            public var decisionTaskCompletedEventId: Number?
        }
        public trait StartTimerFailedEventAttributes {
            public var timerId: String?
            public var cause: String?
            public var decisionTaskCompletedEventId: Number?
        }
        public trait CancelTimerFailedEventAttributes {
            public var timerId: String?
            public var cause: String?
            public var decisionTaskCompletedEventId: Number?
        }
        public trait StartChildWorkflowExecutionFailedEventAttributes {
            public var workflowType: WorkflowType?
            public var cause: String?
            public var workflowId: String?
            public var initiatedEventId: Number?
            public var decisionTaskCompletedEventId: Number?
            public var control: String?
        }
        public trait ActivityTask {
            public var taskToken: String?
            public var activityId: String?
            public var startedEventId: Number?
            public var workflowExecution: WorkflowExecution?
            public var activityType: ActivityType?
            public var input: String?
        }
        public trait PollForActivityTaskResult {
            public var activityTask: ActivityTask?
        }
        public trait PollForDecisionTaskResult {
            public var decisionTask: DecisionTask?
        }
        public trait StartWorkflowExecutionResult {
            public var run: Run?
        }
        public trait Run {
            public var runId: String?
        }
    }
    module
    public object Sns {
        public trait Client {
            public var config: ClientConfig
            public fun publicTopic(params: PublishRequest, callback: (err: Any, data: PublishResult) -> Unit): Unit
            public fun createTopic(params: CreateTopicRequest, callback: (err: Any, data: CreateTopicResult) -> Unit): Unit
            public fun deleteTopic(params: DeleteTopicRequest, callback: (err: Any, data: Any) -> Unit): Unit
        }
        public trait PublishRequest {
            public var TopicArn: String?
            public var Message: String?
            public var MessageStructure: String?
            public var Subject: String?
        }
        public trait PublishResult {
            public var MessageId: String?
        }
        public trait CreateTopicRequest {
            public var Name: String?
        }
        public trait CreateTopicResult {
            public var TopicArn: String?
        }
        public trait DeleteTopicRequest {
            public var TopicArn: String?
        }
    }
    module
    public object s3 {
        public trait Client {
            public var config: ClientConfig
            public fun putObject(params: PutObjectRequest, callback: (err: Any, data: Any) -> Unit): Unit
            public fun getObject(params: GetObjectRequest, callback: (err: Any, data: Any) -> Unit): Unit
        }
        public trait PutObjectRequest {
            public var ACL: String?
            public var Body: Any?
            public var Bucket: String
            public var CacheControl: String?
            public var ContentDisposition: String?
            public var ContentEncoding: String?
            public var ContentLanguage: String?
            public var ContentLength: String?
            public var ContentMD5: String?
            public var ContentType: String?
            public var Expires: Any?
            public var GrantFullControl: String?
            public var GrantRead: String?
            public var GrantReadACP: String?
            public var GrantWriteACP: String?
            public var Key: String
            public var Metadata: Array<String>?
            public var ServerSideEncryption: String?
            public var StorageClass: String?
            public var WebsiteRedirectLocation: String?
        }
        public trait GetObjectRequest {
            public var Bucket: String
            public var IfMatch: String?
            public var IfModifiedSince: Any?
            public var IfNoneMatch: String?
            public var IfUnmodifiedSince: Any?
            public var Key: String
            public var Range: String?
            public var ResponseCacheControl: String?
            public var ResponseContentDisposition: String?
            public var ResponseContentEncoding: String?
            public var ResponseContentLanguage: String?
            public var ResponseContentType: String?
            public var ResponseExpires: Any?
            public var VersionId: String?
        }
    }
}
