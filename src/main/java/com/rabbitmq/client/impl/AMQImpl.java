package com.rabbitmq.client.impl;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.LongString;
import com.rabbitmq.client.UnexpectedMethodError;
import com.rabbitmq.client.UnknownClassOrMethodId;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class AMQImpl implements AMQP {
    public AMQImpl() {
    }

    public static Method readMethodFrom(DataInputStream in) throws IOException {
        int classId = in.readShort();
        int methodId = in.readShort();
        switch(classId) {
            case 10:
                switch(methodId) {
                    case 10:
                        return new AMQImpl.Connection.Start(new MethodArgumentReader(new ValueReader(in)));
                    case 11:
                        return new AMQImpl.Connection.StartOk(new MethodArgumentReader(new ValueReader(in)));
                    case 20:
                        return new AMQImpl.Connection.Secure(new MethodArgumentReader(new ValueReader(in)));
                    case 21:
                        return new AMQImpl.Connection.SecureOk(new MethodArgumentReader(new ValueReader(in)));
                    case 30:
                        return new AMQImpl.Connection.Tune(new MethodArgumentReader(new ValueReader(in)));
                    case 31:
                        return new AMQImpl.Connection.TuneOk(new MethodArgumentReader(new ValueReader(in)));
                    case 40:
                        return new AMQImpl.Connection.Open(new MethodArgumentReader(new ValueReader(in)));
                    case 41:
                        return new AMQImpl.Connection.OpenOk(new MethodArgumentReader(new ValueReader(in)));
                    case 50:
                        return new AMQImpl.Connection.Close(new MethodArgumentReader(new ValueReader(in)));
                    case 51:
                        return new AMQImpl.Connection.CloseOk(new MethodArgumentReader(new ValueReader(in)));
                    case 60:
                        return new AMQImpl.Connection.Blocked(new MethodArgumentReader(new ValueReader(in)));
                    case 61:
                        return new AMQImpl.Connection.Unblocked(new MethodArgumentReader(new ValueReader(in)));
                    case 70:
                        return new AMQImpl.Connection.UpdateSecret(new MethodArgumentReader(new ValueReader(in)));
                    case 71:
                        return new AMQImpl.Connection.UpdateSecretOk(new MethodArgumentReader(new ValueReader(in)));
                    default:
                        throw new UnknownClassOrMethodId(classId, methodId);
                }
            case 20:
                switch(methodId) {
                    case 10:
                        return new AMQImpl.Channel.Open(new MethodArgumentReader(new ValueReader(in)));
                    case 11:
                        return new AMQImpl.Channel.OpenOk(new MethodArgumentReader(new ValueReader(in)));
                    case 20:
                        return new AMQImpl.Channel.Flow(new MethodArgumentReader(new ValueReader(in)));
                    case 21:
                        return new AMQImpl.Channel.FlowOk(new MethodArgumentReader(new ValueReader(in)));
                    case 40:
                        return new AMQImpl.Channel.Close(new MethodArgumentReader(new ValueReader(in)));
                    case 41:
                        return new AMQImpl.Channel.CloseOk(new MethodArgumentReader(new ValueReader(in)));
                    default:
                        throw new UnknownClassOrMethodId(classId, methodId);
                }
            case 30:
                switch(methodId) {
                    case 10:
                        return new AMQImpl.Access.Request(new MethodArgumentReader(new ValueReader(in)));
                    case 11:
                        return new AMQImpl.Access.RequestOk(new MethodArgumentReader(new ValueReader(in)));
                    default:
                        throw new UnknownClassOrMethodId(classId, methodId);
                }
            case 40:
                switch(methodId) {
                    case 10:
                        return new AMQImpl.Exchange.Declare(new MethodArgumentReader(new ValueReader(in)));
                    case 11:
                        return new AMQImpl.Exchange.DeclareOk(new MethodArgumentReader(new ValueReader(in)));
                    case 20:
                        return new AMQImpl.Exchange.Delete(new MethodArgumentReader(new ValueReader(in)));
                    case 21:
                        return new AMQImpl.Exchange.DeleteOk(new MethodArgumentReader(new ValueReader(in)));
                    case 30:
                        return new AMQImpl.Exchange.Bind(new MethodArgumentReader(new ValueReader(in)));
                    case 31:
                        return new AMQImpl.Exchange.BindOk(new MethodArgumentReader(new ValueReader(in)));
                    case 40:
                        return new AMQImpl.Exchange.Unbind(new MethodArgumentReader(new ValueReader(in)));
                    case 51:
                        return new AMQImpl.Exchange.UnbindOk(new MethodArgumentReader(new ValueReader(in)));
                    default:
                        throw new UnknownClassOrMethodId(classId, methodId);
                }
            case 50:
                switch(methodId) {
                    case 10:
                        return new AMQImpl.Queue.Declare(new MethodArgumentReader(new ValueReader(in)));
                    case 11:
                        return new AMQImpl.Queue.DeclareOk(new MethodArgumentReader(new ValueReader(in)));
                    case 20:
                        return new AMQImpl.Queue.Bind(new MethodArgumentReader(new ValueReader(in)));
                    case 21:
                        return new AMQImpl.Queue.BindOk(new MethodArgumentReader(new ValueReader(in)));
                    case 30:
                        return new AMQImpl.Queue.Purge(new MethodArgumentReader(new ValueReader(in)));
                    case 31:
                        return new AMQImpl.Queue.PurgeOk(new MethodArgumentReader(new ValueReader(in)));
                    case 40:
                        return new AMQImpl.Queue.Delete(new MethodArgumentReader(new ValueReader(in)));
                    case 41:
                        return new AMQImpl.Queue.DeleteOk(new MethodArgumentReader(new ValueReader(in)));
                    case 50:
                        return new AMQImpl.Queue.Unbind(new MethodArgumentReader(new ValueReader(in)));
                    case 51:
                        return new AMQImpl.Queue.UnbindOk(new MethodArgumentReader(new ValueReader(in)));
                    default:
                        throw new UnknownClassOrMethodId(classId, methodId);
                }
            case 60:
                switch(methodId) {
                    case 10:
                        return new AMQImpl.Basic.Qos(new MethodArgumentReader(new ValueReader(in)));
                    case 11:
                        return new AMQImpl.Basic.QosOk(new MethodArgumentReader(new ValueReader(in)));
                    case 20:
                        return new AMQImpl.Basic.Consume(new MethodArgumentReader(new ValueReader(in)));
                    case 21:
                        return new AMQImpl.Basic.ConsumeOk(new MethodArgumentReader(new ValueReader(in)));
                    case 30:
                        return new AMQImpl.Basic.Cancel(new MethodArgumentReader(new ValueReader(in)));
                    case 31:
                        return new AMQImpl.Basic.CancelOk(new MethodArgumentReader(new ValueReader(in)));
                    case 40:
                        return new AMQImpl.Basic.Publish(new MethodArgumentReader(new ValueReader(in)));
                    case 50:
                        return new AMQImpl.Basic.Return(new MethodArgumentReader(new ValueReader(in)));
                    case 60:
                        return new AMQImpl.Basic.Deliver(new MethodArgumentReader(new ValueReader(in)));
                    case 70:
                        return new AMQImpl.Basic.Get(new MethodArgumentReader(new ValueReader(in)));
                    case 71:
                        return new AMQImpl.Basic.GetOk(new MethodArgumentReader(new ValueReader(in)));
                    case 72:
                        return new AMQImpl.Basic.GetEmpty(new MethodArgumentReader(new ValueReader(in)));
                    case 80:
                        return new AMQImpl.Basic.Ack(new MethodArgumentReader(new ValueReader(in)));
                    case 90:
                        return new AMQImpl.Basic.Reject(new MethodArgumentReader(new ValueReader(in)));
                    case 100:
                        return new AMQImpl.Basic.RecoverAsync(new MethodArgumentReader(new ValueReader(in)));
                    case 110:
                        return new AMQImpl.Basic.Recover(new MethodArgumentReader(new ValueReader(in)));
                    case 111:
                        return new AMQImpl.Basic.RecoverOk(new MethodArgumentReader(new ValueReader(in)));
                    case 120:
                        return new AMQImpl.Basic.Nack(new MethodArgumentReader(new ValueReader(in)));
                    default:
                        throw new UnknownClassOrMethodId(classId, methodId);
                }
            case 85:
                switch(methodId) {
                    case 10:
                        return new AMQImpl.Confirm.Select(new MethodArgumentReader(new ValueReader(in)));
                    case 11:
                        return new AMQImpl.Confirm.SelectOk(new MethodArgumentReader(new ValueReader(in)));
                    default:
                        throw new UnknownClassOrMethodId(classId, methodId);
                }
            case 90:
                switch(methodId) {
                    case 10:
                        return new AMQImpl.Tx.Select(new MethodArgumentReader(new ValueReader(in)));
                    case 11:
                        return new AMQImpl.Tx.SelectOk(new MethodArgumentReader(new ValueReader(in)));
                    case 20:
                        return new AMQImpl.Tx.Commit(new MethodArgumentReader(new ValueReader(in)));
                    case 21:
                        return new AMQImpl.Tx.CommitOk(new MethodArgumentReader(new ValueReader(in)));
                    case 30:
                        return new AMQImpl.Tx.Rollback(new MethodArgumentReader(new ValueReader(in)));
                    case 31:
                        return new AMQImpl.Tx.RollbackOk(new MethodArgumentReader(new ValueReader(in)));
                }
        }

        throw new UnknownClassOrMethodId(classId, methodId);
    }

    public static AMQContentHeader readContentHeaderFrom(DataInputStream in) throws IOException {
        int classId = in.readShort();
        switch(classId) {
            case 60:
                return new BasicProperties(in);
            default:
                throw new UnknownClassOrMethodId(classId);
        }
    }

    public static class DefaultMethodVisitor implements AMQImpl.MethodVisitor {
        public DefaultMethodVisitor() {
        }

        public Object visit(AMQImpl.Connection.Start x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Connection.StartOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Connection.Secure x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Connection.SecureOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Connection.Tune x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Connection.TuneOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Connection.Open x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Connection.OpenOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Connection.Close x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Connection.CloseOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Connection.Blocked x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Connection.Unblocked x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Connection.UpdateSecret x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Connection.UpdateSecretOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Channel.Open x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Channel.OpenOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Channel.Flow x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Channel.FlowOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Channel.Close x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Channel.CloseOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Access.Request x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Access.RequestOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Exchange.Declare x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Exchange.DeclareOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Exchange.Delete x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Exchange.DeleteOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Exchange.Bind x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Exchange.BindOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Exchange.Unbind x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Exchange.UnbindOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Queue.Declare x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Queue.DeclareOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Queue.Bind x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Queue.BindOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Queue.Purge x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Queue.PurgeOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Queue.Delete x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Queue.DeleteOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Queue.Unbind x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Queue.UnbindOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.Qos x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.QosOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.Consume x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.ConsumeOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.Cancel x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.CancelOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.Publish x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.Return x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.Deliver x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.Get x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.GetOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.GetEmpty x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.Ack x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.Reject x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.RecoverAsync x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.Recover x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.RecoverOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Basic.Nack x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Tx.Select x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Tx.SelectOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Tx.Commit x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Tx.CommitOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Tx.Rollback x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Tx.RollbackOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Confirm.Select x) throws IOException {
            throw new UnexpectedMethodError(x);
        }

        public Object visit(AMQImpl.Confirm.SelectOk x) throws IOException {
            throw new UnexpectedMethodError(x);
        }
    }

    public interface MethodVisitor {
        Object visit(AMQImpl.Connection.Start var1) throws IOException;

        Object visit(AMQImpl.Connection.StartOk var1) throws IOException;

        Object visit(AMQImpl.Connection.Secure var1) throws IOException;

        Object visit(AMQImpl.Connection.SecureOk var1) throws IOException;

        Object visit(AMQImpl.Connection.Tune var1) throws IOException;

        Object visit(AMQImpl.Connection.TuneOk var1) throws IOException;

        Object visit(AMQImpl.Connection.Open var1) throws IOException;

        Object visit(AMQImpl.Connection.OpenOk var1) throws IOException;

        Object visit(AMQImpl.Connection.Close var1) throws IOException;

        Object visit(AMQImpl.Connection.CloseOk var1) throws IOException;

        Object visit(AMQImpl.Connection.Blocked var1) throws IOException;

        Object visit(AMQImpl.Connection.Unblocked var1) throws IOException;

        Object visit(AMQImpl.Connection.UpdateSecret var1) throws IOException;

        Object visit(AMQImpl.Connection.UpdateSecretOk var1) throws IOException;

        Object visit(AMQImpl.Channel.Open var1) throws IOException;

        Object visit(AMQImpl.Channel.OpenOk var1) throws IOException;

        Object visit(AMQImpl.Channel.Flow var1) throws IOException;

        Object visit(AMQImpl.Channel.FlowOk var1) throws IOException;

        Object visit(AMQImpl.Channel.Close var1) throws IOException;

        Object visit(AMQImpl.Channel.CloseOk var1) throws IOException;

        Object visit(AMQImpl.Access.Request var1) throws IOException;

        Object visit(AMQImpl.Access.RequestOk var1) throws IOException;

        Object visit(AMQImpl.Exchange.Declare var1) throws IOException;

        Object visit(AMQImpl.Exchange.DeclareOk var1) throws IOException;

        Object visit(AMQImpl.Exchange.Delete var1) throws IOException;

        Object visit(AMQImpl.Exchange.DeleteOk var1) throws IOException;

        Object visit(AMQImpl.Exchange.Bind var1) throws IOException;

        Object visit(AMQImpl.Exchange.BindOk var1) throws IOException;

        Object visit(AMQImpl.Exchange.Unbind var1) throws IOException;

        Object visit(AMQImpl.Exchange.UnbindOk var1) throws IOException;

        Object visit(AMQImpl.Queue.Declare var1) throws IOException;

        Object visit(AMQImpl.Queue.DeclareOk var1) throws IOException;

        Object visit(AMQImpl.Queue.Bind var1) throws IOException;

        Object visit(AMQImpl.Queue.BindOk var1) throws IOException;

        Object visit(AMQImpl.Queue.Purge var1) throws IOException;

        Object visit(AMQImpl.Queue.PurgeOk var1) throws IOException;

        Object visit(AMQImpl.Queue.Delete var1) throws IOException;

        Object visit(AMQImpl.Queue.DeleteOk var1) throws IOException;

        Object visit(AMQImpl.Queue.Unbind var1) throws IOException;

        Object visit(AMQImpl.Queue.UnbindOk var1) throws IOException;

        Object visit(AMQImpl.Basic.Qos var1) throws IOException;

        Object visit(AMQImpl.Basic.QosOk var1) throws IOException;

        Object visit(AMQImpl.Basic.Consume var1) throws IOException;

        Object visit(AMQImpl.Basic.ConsumeOk var1) throws IOException;

        Object visit(AMQImpl.Basic.Cancel var1) throws IOException;

        Object visit(AMQImpl.Basic.CancelOk var1) throws IOException;

        Object visit(AMQImpl.Basic.Publish var1) throws IOException;

        Object visit(AMQImpl.Basic.Return var1) throws IOException;

        Object visit(AMQImpl.Basic.Deliver var1) throws IOException;

        Object visit(AMQImpl.Basic.Get var1) throws IOException;

        Object visit(AMQImpl.Basic.GetOk var1) throws IOException;

        Object visit(AMQImpl.Basic.GetEmpty var1) throws IOException;

        Object visit(AMQImpl.Basic.Ack var1) throws IOException;

        Object visit(AMQImpl.Basic.Reject var1) throws IOException;

        Object visit(AMQImpl.Basic.RecoverAsync var1) throws IOException;

        Object visit(AMQImpl.Basic.Recover var1) throws IOException;

        Object visit(AMQImpl.Basic.RecoverOk var1) throws IOException;

        Object visit(AMQImpl.Basic.Nack var1) throws IOException;

        Object visit(AMQImpl.Tx.Select var1) throws IOException;

        Object visit(AMQImpl.Tx.SelectOk var1) throws IOException;

        Object visit(AMQImpl.Tx.Commit var1) throws IOException;

        Object visit(AMQImpl.Tx.CommitOk var1) throws IOException;

        Object visit(AMQImpl.Tx.Rollback var1) throws IOException;

        Object visit(AMQImpl.Tx.RollbackOk var1) throws IOException;

        Object visit(AMQImpl.Confirm.Select var1) throws IOException;

        Object visit(AMQImpl.Confirm.SelectOk var1) throws IOException;
    }

    public static class Confirm {
        public static final int INDEX = 85;

        public Confirm() {
        }

        public static class SelectOk extends Method implements com.rabbitmq.client.AMQP.Confirm.SelectOk {
            public static final int INDEX = 11;

            public SelectOk() {
            }

            public SelectOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 85;
            }

            public int protocolMethodId() {
                return 11;
            }

            public String protocolMethodName() {
                return "confirm.select-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Select extends Method implements com.rabbitmq.client.AMQP.Confirm.Select {
            public static final int INDEX = 10;
            private final boolean nowait;

            public boolean getNowait() {
                return this.nowait;
            }

            public Select(boolean nowait) {
                this.nowait = nowait;
            }

            public Select(MethodArgumentReader rdr) throws IOException {
                this(rdr.readBit());
            }

            public int protocolClassId() {
                return 85;
            }

            public int protocolMethodId() {
                return 10;
            }

            public String protocolMethodName() {
                return "confirm.select";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Confirm.Select that = (AMQImpl.Confirm.Select)o;
                    return this.nowait == that.nowait;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.nowait ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(nowait=").append(this.nowait).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeBit(this.nowait);
            }
        }
    }

    public static class Tx {
        public static final int INDEX = 90;

        public Tx() {
        }

        public static class RollbackOk extends Method implements com.rabbitmq.client.AMQP.Tx.RollbackOk {
            public static final int INDEX = 31;

            public RollbackOk() {
            }

            public RollbackOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 90;
            }

            public int protocolMethodId() {
                return 31;
            }

            public String protocolMethodName() {
                return "tx.rollback-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Rollback extends Method implements com.rabbitmq.client.AMQP.Tx.Rollback {
            public static final int INDEX = 30;

            public Rollback() {
            }

            public Rollback(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 90;
            }

            public int protocolMethodId() {
                return 30;
            }

            public String protocolMethodName() {
                return "tx.rollback";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class CommitOk extends Method implements com.rabbitmq.client.AMQP.Tx.CommitOk {
            public static final int INDEX = 21;

            public CommitOk() {
            }

            public CommitOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 90;
            }

            public int protocolMethodId() {
                return 21;
            }

            public String protocolMethodName() {
                return "tx.commit-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Commit extends Method implements com.rabbitmq.client.AMQP.Tx.Commit {
            public static final int INDEX = 20;

            public Commit() {
            }

            public Commit(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 90;
            }

            public int protocolMethodId() {
                return 20;
            }

            public String protocolMethodName() {
                return "tx.commit";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class SelectOk extends Method implements com.rabbitmq.client.AMQP.Tx.SelectOk {
            public static final int INDEX = 11;

            public SelectOk() {
            }

            public SelectOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 90;
            }

            public int protocolMethodId() {
                return 11;
            }

            public String protocolMethodName() {
                return "tx.select-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Select extends Method implements com.rabbitmq.client.AMQP.Tx.Select {
            public static final int INDEX = 10;

            public Select() {
            }

            public Select(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 90;
            }

            public int protocolMethodId() {
                return 10;
            }

            public String protocolMethodName() {
                return "tx.select";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }
    }

    public static class Basic {
        public static final int INDEX = 60;

        public Basic() {
        }

        public static class Nack extends Method implements com.rabbitmq.client.AMQP.Basic.Nack {
            public static final int INDEX = 120;
            private final long deliveryTag;
            private final boolean multiple;
            private final boolean requeue;

            public long getDeliveryTag() {
                return this.deliveryTag;
            }

            public boolean getMultiple() {
                return this.multiple;
            }

            public boolean getRequeue() {
                return this.requeue;
            }

            public Nack(long deliveryTag, boolean multiple, boolean requeue) {
                this.deliveryTag = deliveryTag;
                this.multiple = multiple;
                this.requeue = requeue;
            }

            public Nack(MethodArgumentReader rdr) throws IOException {
                this(rdr.readLonglong(), rdr.readBit(), rdr.readBit());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 120;
            }

            public String protocolMethodName() {
                return "basic.nack";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.Nack that = (AMQImpl.Basic.Nack)o;
                    if (this.deliveryTag != that.deliveryTag) {
                        return false;
                    } else if (this.multiple != that.multiple) {
                        return false;
                    } else {
                        return this.requeue == that.requeue;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (int)(this.deliveryTag ^ this.deliveryTag >>> 32);
                result = 31 * result + (this.multiple ? 1 : 0);
                result = 31 * result + (this.requeue ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(delivery-tag=").append(this.deliveryTag).append(", multiple=").append(this.multiple).append(", requeue=").append(this.requeue).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeLonglong(this.deliveryTag);
                writer.writeBit(this.multiple);
                writer.writeBit(this.requeue);
            }
        }

        public static class RecoverOk extends Method implements com.rabbitmq.client.AMQP.Basic.RecoverOk {
            public static final int INDEX = 111;

            public RecoverOk() {
            }

            public RecoverOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 111;
            }

            public String protocolMethodName() {
                return "basic.recover-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Recover extends Method implements com.rabbitmq.client.AMQP.Basic.Recover {
            public static final int INDEX = 110;
            private final boolean requeue;

            public boolean getRequeue() {
                return this.requeue;
            }

            public Recover(boolean requeue) {
                this.requeue = requeue;
            }

            public Recover(MethodArgumentReader rdr) throws IOException {
                this(rdr.readBit());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 110;
            }

            public String protocolMethodName() {
                return "basic.recover";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.Recover that = (AMQImpl.Basic.Recover)o;
                    return this.requeue == that.requeue;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.requeue ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(requeue=").append(this.requeue).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeBit(this.requeue);
            }
        }

        public static class RecoverAsync extends Method implements com.rabbitmq.client.AMQP.Basic.RecoverAsync {
            public static final int INDEX = 100;
            private final boolean requeue;

            public boolean getRequeue() {
                return this.requeue;
            }

            public RecoverAsync(boolean requeue) {
                this.requeue = requeue;
            }

            public RecoverAsync(MethodArgumentReader rdr) throws IOException {
                this(rdr.readBit());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 100;
            }

            public String protocolMethodName() {
                return "basic.recover-async";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.RecoverAsync that = (AMQImpl.Basic.RecoverAsync)o;
                    return this.requeue == that.requeue;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.requeue ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(requeue=").append(this.requeue).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeBit(this.requeue);
            }
        }

        public static class Reject extends Method implements com.rabbitmq.client.AMQP.Basic.Reject {
            public static final int INDEX = 90;
            private final long deliveryTag;
            private final boolean requeue;

            public long getDeliveryTag() {
                return this.deliveryTag;
            }

            public boolean getRequeue() {
                return this.requeue;
            }

            public Reject(long deliveryTag, boolean requeue) {
                this.deliveryTag = deliveryTag;
                this.requeue = requeue;
            }

            public Reject(MethodArgumentReader rdr) throws IOException {
                this(rdr.readLonglong(), rdr.readBit());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 90;
            }

            public String protocolMethodName() {
                return "basic.reject";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.Reject that = (AMQImpl.Basic.Reject)o;
                    if (this.deliveryTag != that.deliveryTag) {
                        return false;
                    } else {
                        return this.requeue == that.requeue;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (int)(this.deliveryTag ^ this.deliveryTag >>> 32);
                result = 31 * result + (this.requeue ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(delivery-tag=").append(this.deliveryTag).append(", requeue=").append(this.requeue).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeLonglong(this.deliveryTag);
                writer.writeBit(this.requeue);
            }
        }

        public static class Ack extends Method implements com.rabbitmq.client.AMQP.Basic.Ack {
            public static final int INDEX = 80;
            private final long deliveryTag;
            private final boolean multiple;

            public long getDeliveryTag() {
                return this.deliveryTag;
            }

            public boolean getMultiple() {
                return this.multiple;
            }

            public Ack(long deliveryTag, boolean multiple) {
                this.deliveryTag = deliveryTag;
                this.multiple = multiple;
            }

            public Ack(MethodArgumentReader rdr) throws IOException {
                this(rdr.readLonglong(), rdr.readBit());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 80;
            }

            public String protocolMethodName() {
                return "basic.ack";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.Ack that = (AMQImpl.Basic.Ack)o;
                    if (this.deliveryTag != that.deliveryTag) {
                        return false;
                    } else {
                        return this.multiple == that.multiple;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (int)(this.deliveryTag ^ this.deliveryTag >>> 32);
                result = 31 * result + (this.multiple ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(delivery-tag=").append(this.deliveryTag).append(", multiple=").append(this.multiple).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeLonglong(this.deliveryTag);
                writer.writeBit(this.multiple);
            }
        }

        public static class GetEmpty extends Method implements com.rabbitmq.client.AMQP.Basic.GetEmpty {
            public static final int INDEX = 72;
            private final String clusterId;

            public String getClusterId() {
                return this.clusterId;
            }

            public GetEmpty(String clusterId) {
                if (clusterId == null) {
                    throw new IllegalStateException("Invalid configuration: 'clusterId' must be non-null.");
                } else {
                    this.clusterId = clusterId;
                }
            }

            public GetEmpty(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShortstr());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 72;
            }

            public String protocolMethodName() {
                return "basic.get-empty";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.GetEmpty that = (AMQImpl.Basic.GetEmpty)o;
                    if (this.clusterId != null) {
                        if (!this.clusterId.equals(that.clusterId)) {
                            return false;
                        }
                    } else if (that.clusterId != null) {
                        return false;
                    }

                    return true;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.clusterId != null ? this.clusterId.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(cluster-id=").append(this.clusterId).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShortstr(this.clusterId);
            }
        }

        public static class GetOk extends Method implements com.rabbitmq.client.AMQP.Basic.GetOk {
            public static final int INDEX = 71;
            private final long deliveryTag;
            private final boolean redelivered;
            private final String exchange;
            private final String routingKey;
            private final int messageCount;

            public long getDeliveryTag() {
                return this.deliveryTag;
            }

            public boolean getRedelivered() {
                return this.redelivered;
            }

            public String getExchange() {
                return this.exchange;
            }

            public String getRoutingKey() {
                return this.routingKey;
            }

            public int getMessageCount() {
                return this.messageCount;
            }

            public GetOk(long deliveryTag, boolean redelivered, String exchange, String routingKey, int messageCount) {
                if (exchange == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else if (routingKey == null) {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                } else {
                    this.deliveryTag = deliveryTag;
                    this.redelivered = redelivered;
                    this.exchange = exchange;
                    this.routingKey = routingKey;
                    this.messageCount = messageCount;
                }
            }

            public GetOk(MethodArgumentReader rdr) throws IOException {
                this(rdr.readLonglong(), rdr.readBit(), rdr.readShortstr(), rdr.readShortstr(), rdr.readLong());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 71;
            }

            public String protocolMethodName() {
                return "basic.get-ok";
            }

            public boolean hasContent() {
                return true;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.GetOk that = (AMQImpl.Basic.GetOk)o;
                    if (this.deliveryTag != that.deliveryTag) {
                        return false;
                    } else if (this.redelivered != that.redelivered) {
                        return false;
                    } else {
                        label42: {
                            if (this.exchange != null) {
                                if (this.exchange.equals(that.exchange)) {
                                    break label42;
                                }
                            } else if (that.exchange == null) {
                                break label42;
                            }

                            return false;
                        }

                        if (this.routingKey != null) {
                            if (!this.routingKey.equals(that.routingKey)) {
                                return false;
                            }
                        } else if (that.routingKey != null) {
                            return false;
                        }

                        if (this.messageCount != that.messageCount) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (int)(this.deliveryTag ^ this.deliveryTag >>> 32);
                result = 31 * result + (this.redelivered ? 1 : 0);
                result = 31 * result + (this.exchange != null ? this.exchange.hashCode() : 0);
                result = 31 * result + (this.routingKey != null ? this.routingKey.hashCode() : 0);
                result = 31 * result + this.messageCount;
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(delivery-tag=").append(this.deliveryTag).append(", redelivered=").append(this.redelivered).append(", exchange=").append(this.exchange).append(", routing-key=").append(this.routingKey).append(", message-count=").append(this.messageCount).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeLonglong(this.deliveryTag);
                writer.writeBit(this.redelivered);
                writer.writeShortstr(this.exchange);
                writer.writeShortstr(this.routingKey);
                writer.writeLong(this.messageCount);
            }
        }

        public static class Get extends Method implements com.rabbitmq.client.AMQP.Basic.Get {
            public static final int INDEX = 70;
            private final int ticket;
            private final String queue;
            private final boolean noAck;

            public int getTicket() {
                return this.ticket;
            }

            public String getQueue() {
                return this.queue;
            }

            public boolean getNoAck() {
                return this.noAck;
            }

            public Get(int ticket, String queue, boolean noAck) {
                if (queue == null) {
                    throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
                } else {
                    this.ticket = ticket;
                    this.queue = queue;
                    this.noAck = noAck;
                }
            }

            public Get(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readBit());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 70;
            }

            public String protocolMethodName() {
                return "basic.get";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.Get that = (AMQImpl.Basic.Get)o;
                    if (this.ticket != that.ticket) {
                        return false;
                    } else {
                        if (this.queue != null) {
                            if (this.queue.equals(that.queue)) {
                                return this.noAck == that.noAck;
                            }
                        } else if (that.queue == null) {
                            return this.noAck == that.noAck;
                        }

                        return false;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.ticket;
                result = 31 * result + (this.queue != null ? this.queue.hashCode() : 0);
                result = 31 * result + (this.noAck ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(ticket=").append(this.ticket).append(", queue=").append(this.queue).append(", no-ack=").append(this.noAck).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.ticket);
                writer.writeShortstr(this.queue);
                writer.writeBit(this.noAck);
            }
        }

        public static class Deliver extends Method implements com.rabbitmq.client.AMQP.Basic.Deliver {
            public static final int INDEX = 60;
            private final String consumerTag;
            private final long deliveryTag;
            private final boolean redelivered;
            private final String exchange;
            private final String routingKey;

            public String getConsumerTag() {
                return this.consumerTag;
            }

            public long getDeliveryTag() {
                return this.deliveryTag;
            }

            public boolean getRedelivered() {
                return this.redelivered;
            }

            public String getExchange() {
                return this.exchange;
            }

            public String getRoutingKey() {
                return this.routingKey;
            }

            public Deliver(String consumerTag, long deliveryTag, boolean redelivered, String exchange, String routingKey) {
                if (consumerTag == null) {
                    throw new IllegalStateException("Invalid configuration: 'consumerTag' must be non-null.");
                } else if (exchange == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else if (routingKey == null) {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                } else {
                    this.consumerTag = consumerTag;
                    this.deliveryTag = deliveryTag;
                    this.redelivered = redelivered;
                    this.exchange = exchange;
                    this.routingKey = routingKey;
                }
            }

            public Deliver(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShortstr(), rdr.readLonglong(), rdr.readBit(), rdr.readShortstr(), rdr.readShortstr());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 60;
            }

            public String protocolMethodName() {
                return "basic.deliver";
            }

            public boolean hasContent() {
                return true;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.Deliver that = (AMQImpl.Basic.Deliver)o;
                    if (this.consumerTag != null) {
                        if (!this.consumerTag.equals(that.consumerTag)) {
                            return false;
                        }
                    } else if (that.consumerTag != null) {
                        return false;
                    }

                    if (this.deliveryTag != that.deliveryTag) {
                        return false;
                    } else if (this.redelivered != that.redelivered) {
                        return false;
                    } else {
                        if (this.exchange != null) {
                            if (!this.exchange.equals(that.exchange)) {
                                return false;
                            }
                        } else if (that.exchange != null) {
                            return false;
                        }

                        if (this.routingKey != null) {
                            if (!this.routingKey.equals(that.routingKey)) {
                                return false;
                            }
                        } else if (that.routingKey != null) {
                            return false;
                        }

                        return true;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.consumerTag != null ? this.consumerTag.hashCode() : 0);
                result = 31 * result + (int)(this.deliveryTag ^ this.deliveryTag >>> 32);
                result = 31 * result + (this.redelivered ? 1 : 0);
                result = 31 * result + (this.exchange != null ? this.exchange.hashCode() : 0);
                result = 31 * result + (this.routingKey != null ? this.routingKey.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(consumer-tag=").append(this.consumerTag).append(", delivery-tag=").append(this.deliveryTag).append(", redelivered=").append(this.redelivered).append(", exchange=").append(this.exchange).append(", routing-key=").append(this.routingKey).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShortstr(this.consumerTag);
                writer.writeLonglong(this.deliveryTag);
                writer.writeBit(this.redelivered);
                writer.writeShortstr(this.exchange);
                writer.writeShortstr(this.routingKey);
            }
        }

        public static class Return extends Method implements com.rabbitmq.client.AMQP.Basic.Return {
            public static final int INDEX = 50;
            private final int replyCode;
            private final String replyText;
            private final String exchange;
            private final String routingKey;

            public int getReplyCode() {
                return this.replyCode;
            }

            public String getReplyText() {
                return this.replyText;
            }

            public String getExchange() {
                return this.exchange;
            }

            public String getRoutingKey() {
                return this.routingKey;
            }

            public Return(int replyCode, String replyText, String exchange, String routingKey) {
                if (exchange == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else if (replyText == null) {
                    throw new IllegalStateException("Invalid configuration: 'replyText' must be non-null.");
                } else if (routingKey == null) {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                } else {
                    this.replyCode = replyCode;
                    this.replyText = replyText;
                    this.exchange = exchange;
                    this.routingKey = routingKey;
                }
            }

            public Return(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readShortstr(), rdr.readShortstr());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 50;
            }

            public String protocolMethodName() {
                return "basic.return";
            }

            public boolean hasContent() {
                return true;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.Return that = (AMQImpl.Basic.Return)o;
                    if (this.replyCode != that.replyCode) {
                        return false;
                    } else {
                        label48: {
                            if (this.replyText != null) {
                                if (this.replyText.equals(that.replyText)) {
                                    break label48;
                                }
                            } else if (that.replyText == null) {
                                break label48;
                            }

                            return false;
                        }

                        if (this.exchange != null) {
                            if (!this.exchange.equals(that.exchange)) {
                                return false;
                            }
                        } else if (that.exchange != null) {
                            return false;
                        }

                        if (this.routingKey != null) {
                            if (!this.routingKey.equals(that.routingKey)) {
                                return false;
                            }
                        } else if (that.routingKey != null) {
                            return false;
                        }

                        return true;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.replyCode;
                result = 31 * result + (this.replyText != null ? this.replyText.hashCode() : 0);
                result = 31 * result + (this.exchange != null ? this.exchange.hashCode() : 0);
                result = 31 * result + (this.routingKey != null ? this.routingKey.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(reply-code=").append(this.replyCode).append(", reply-text=").append(this.replyText).append(", exchange=").append(this.exchange).append(", routing-key=").append(this.routingKey).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.replyCode);
                writer.writeShortstr(this.replyText);
                writer.writeShortstr(this.exchange);
                writer.writeShortstr(this.routingKey);
            }
        }

        public static class Publish extends Method implements com.rabbitmq.client.AMQP.Basic.Publish {
            public static final int INDEX = 40;
            private final int ticket;
            private final String exchange;
            private final String routingKey;
            private final boolean mandatory;
            private final boolean immediate;

            public int getTicket() {
                return this.ticket;
            }

            public String getExchange() {
                return this.exchange;
            }

            public String getRoutingKey() {
                return this.routingKey;
            }

            public boolean getMandatory() {
                return this.mandatory;
            }

            public boolean getImmediate() {
                return this.immediate;
            }

            public Publish(int ticket, String exchange, String routingKey, boolean mandatory, boolean immediate) {
                if (exchange == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else if (routingKey == null) {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                } else {
                    this.ticket = ticket;
                    this.exchange = exchange;
                    this.routingKey = routingKey;
                    this.mandatory = mandatory;
                    this.immediate = immediate;
                }
            }

            public Publish(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readShortstr(), rdr.readBit(), rdr.readBit());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 40;
            }

            public String protocolMethodName() {
                return "basic.publish";
            }

            public boolean hasContent() {
                return true;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.Publish that = (AMQImpl.Basic.Publish)o;
                    if (this.ticket != that.ticket) {
                        return false;
                    } else {
                        label44: {
                            if (this.exchange != null) {
                                if (this.exchange.equals(that.exchange)) {
                                    break label44;
                                }
                            } else if (that.exchange == null) {
                                break label44;
                            }

                            return false;
                        }

                        if (this.routingKey != null) {
                            if (!this.routingKey.equals(that.routingKey)) {
                                return false;
                            }
                        } else if (that.routingKey != null) {
                            return false;
                        }

                        if (this.mandatory != that.mandatory) {
                            return false;
                        } else if (this.immediate != that.immediate) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.ticket;
                result = 31 * result + (this.exchange != null ? this.exchange.hashCode() : 0);
                result = 31 * result + (this.routingKey != null ? this.routingKey.hashCode() : 0);
                result = 31 * result + (this.mandatory ? 1 : 0);
                result = 31 * result + (this.immediate ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(ticket=").append(this.ticket).append(", exchange=").append(this.exchange).append(", routing-key=").append(this.routingKey).append(", mandatory=").append(this.mandatory).append(", immediate=").append(this.immediate).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.ticket);
                writer.writeShortstr(this.exchange);
                writer.writeShortstr(this.routingKey);
                writer.writeBit(this.mandatory);
                writer.writeBit(this.immediate);
            }
        }

        public static class CancelOk extends Method implements com.rabbitmq.client.AMQP.Basic.CancelOk {
            public static final int INDEX = 31;
            private final String consumerTag;

            public String getConsumerTag() {
                return this.consumerTag;
            }

            public CancelOk(String consumerTag) {
                if (consumerTag == null) {
                    throw new IllegalStateException("Invalid configuration: 'consumerTag' must be non-null.");
                } else {
                    this.consumerTag = consumerTag;
                }
            }

            public CancelOk(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShortstr());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 31;
            }

            public String protocolMethodName() {
                return "basic.cancel-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.CancelOk that = (AMQImpl.Basic.CancelOk)o;
                    if (this.consumerTag != null) {
                        if (!this.consumerTag.equals(that.consumerTag)) {
                            return false;
                        }
                    } else if (that.consumerTag != null) {
                        return false;
                    }

                    return true;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.consumerTag != null ? this.consumerTag.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(consumer-tag=").append(this.consumerTag).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShortstr(this.consumerTag);
            }
        }

        public static class Cancel extends Method implements com.rabbitmq.client.AMQP.Basic.Cancel {
            public static final int INDEX = 30;
            private final String consumerTag;
            private final boolean nowait;

            public String getConsumerTag() {
                return this.consumerTag;
            }

            public boolean getNowait() {
                return this.nowait;
            }

            public Cancel(String consumerTag, boolean nowait) {
                if (consumerTag == null) {
                    throw new IllegalStateException("Invalid configuration: 'consumerTag' must be non-null.");
                } else {
                    this.consumerTag = consumerTag;
                    this.nowait = nowait;
                }
            }

            public Cancel(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShortstr(), rdr.readBit());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 30;
            }

            public String protocolMethodName() {
                return "basic.cancel";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.Cancel that = (AMQImpl.Basic.Cancel)o;
                    if (this.consumerTag != null) {
                        if (this.consumerTag.equals(that.consumerTag)) {
                            return this.nowait == that.nowait;
                        }
                    } else if (that.consumerTag == null) {
                        return this.nowait == that.nowait;
                    }

                    return false;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.consumerTag != null ? this.consumerTag.hashCode() : 0);
                result = 31 * result + (this.nowait ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(consumer-tag=").append(this.consumerTag).append(", nowait=").append(this.nowait).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShortstr(this.consumerTag);
                writer.writeBit(this.nowait);
            }
        }

        public static class ConsumeOk extends Method implements com.rabbitmq.client.AMQP.Basic.ConsumeOk {
            public static final int INDEX = 21;
            private final String consumerTag;

            public String getConsumerTag() {
                return this.consumerTag;
            }

            public ConsumeOk(String consumerTag) {
                if (consumerTag == null) {
                    throw new IllegalStateException("Invalid configuration: 'consumerTag' must be non-null.");
                } else {
                    this.consumerTag = consumerTag;
                }
            }

            public ConsumeOk(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShortstr());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 21;
            }

            public String protocolMethodName() {
                return "basic.consume-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.ConsumeOk that = (AMQImpl.Basic.ConsumeOk)o;
                    if (this.consumerTag != null) {
                        if (!this.consumerTag.equals(that.consumerTag)) {
                            return false;
                        }
                    } else if (that.consumerTag != null) {
                        return false;
                    }

                    return true;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.consumerTag != null ? this.consumerTag.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(consumer-tag=").append(this.consumerTag).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShortstr(this.consumerTag);
            }
        }

        public static class Consume extends Method implements com.rabbitmq.client.AMQP.Basic.Consume {
            public static final int INDEX = 20;
            private final int ticket;
            private final String queue;
            private final String consumerTag;
            private final boolean noLocal;
            private final boolean noAck;
            private final boolean exclusive;
            private final boolean nowait;
            private final Map<String, Object> arguments;

            public int getTicket() {
                return this.ticket;
            }

            public String getQueue() {
                return this.queue;
            }

            public String getConsumerTag() {
                return this.consumerTag;
            }

            public boolean getNoLocal() {
                return this.noLocal;
            }

            public boolean getNoAck() {
                return this.noAck;
            }

            public boolean getExclusive() {
                return this.exclusive;
            }

            public boolean getNowait() {
                return this.nowait;
            }

            public Map<String, Object> getArguments() {
                return this.arguments;
            }

            public Consume(int ticket, String queue, String consumerTag, boolean noLocal, boolean noAck, boolean exclusive, boolean nowait, Map<String, Object> arguments) {
                if (consumerTag == null) {
                    throw new IllegalStateException("Invalid configuration: 'consumerTag' must be non-null.");
                } else if (queue == null) {
                    throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
                } else {
                    this.ticket = ticket;
                    this.queue = queue;
                    this.consumerTag = consumerTag;
                    this.noLocal = noLocal;
                    this.noAck = noAck;
                    this.exclusive = exclusive;
                    this.nowait = nowait;
                    this.arguments = arguments == null ? null : Collections.unmodifiableMap(new HashMap(arguments));
                }
            }

            public Consume(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readShortstr(), rdr.readBit(), rdr.readBit(), rdr.readBit(), rdr.readBit(), rdr.readTable());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 20;
            }

            public String protocolMethodName() {
                return "basic.consume";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.Consume that = (AMQImpl.Basic.Consume)o;
                    if (this.ticket != that.ticket) {
                        return false;
                    } else {
                        label64: {
                            if (this.queue != null) {
                                if (this.queue.equals(that.queue)) {
                                    break label64;
                                }
                            } else if (that.queue == null) {
                                break label64;
                            }

                            return false;
                        }

                        if (this.consumerTag != null) {
                            if (!this.consumerTag.equals(that.consumerTag)) {
                                return false;
                            }
                        } else if (that.consumerTag != null) {
                            return false;
                        }

                        if (this.noLocal != that.noLocal) {
                            return false;
                        } else if (this.noAck != that.noAck) {
                            return false;
                        } else if (this.exclusive != that.exclusive) {
                            return false;
                        } else if (this.nowait != that.nowait) {
                            return false;
                        } else {
                            if (this.arguments != null) {
                                if (!this.arguments.equals(that.arguments)) {
                                    return false;
                                }
                            } else if (that.arguments != null) {
                                return false;
                            }

                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.ticket;
                result = 31 * result + (this.queue != null ? this.queue.hashCode() : 0);
                result = 31 * result + (this.consumerTag != null ? this.consumerTag.hashCode() : 0);
                result = 31 * result + (this.noLocal ? 1 : 0);
                result = 31 * result + (this.noAck ? 1 : 0);
                result = 31 * result + (this.exclusive ? 1 : 0);
                result = 31 * result + (this.nowait ? 1 : 0);
                result = 31 * result + (this.arguments != null ? this.arguments.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(ticket=").append(this.ticket).append(", queue=").append(this.queue).append(", consumer-tag=").append(this.consumerTag).append(", no-local=").append(this.noLocal).append(", no-ack=").append(this.noAck).append(", exclusive=").append(this.exclusive).append(", nowait=").append(this.nowait).append(", arguments=").append(this.arguments).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.ticket);
                writer.writeShortstr(this.queue);
                writer.writeShortstr(this.consumerTag);
                writer.writeBit(this.noLocal);
                writer.writeBit(this.noAck);
                writer.writeBit(this.exclusive);
                writer.writeBit(this.nowait);
                writer.writeTable(this.arguments);
            }
        }

        public static class QosOk extends Method implements com.rabbitmq.client.AMQP.Basic.QosOk {
            public static final int INDEX = 11;

            public QosOk() {
            }

            public QosOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 11;
            }

            public String protocolMethodName() {
                return "basic.qos-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Qos extends Method implements com.rabbitmq.client.AMQP.Basic.Qos {
            public static final int INDEX = 10;
            private final int prefetchSize;
            private final int prefetchCount;
            private final boolean global;

            public int getPrefetchSize() {
                return this.prefetchSize;
            }

            public int getPrefetchCount() {
                return this.prefetchCount;
            }

            public boolean getGlobal() {
                return this.global;
            }

            public Qos(int prefetchSize, int prefetchCount, boolean global) {
                this.prefetchSize = prefetchSize;
                this.prefetchCount = prefetchCount;
                this.global = global;
            }

            public Qos(MethodArgumentReader rdr) throws IOException {
                this(rdr.readLong(), rdr.readShort(), rdr.readBit());
            }

            public int protocolClassId() {
                return 60;
            }

            public int protocolMethodId() {
                return 10;
            }

            public String protocolMethodName() {
                return "basic.qos";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Basic.Qos that = (AMQImpl.Basic.Qos)o;
                    if (this.prefetchSize != that.prefetchSize) {
                        return false;
                    } else if (this.prefetchCount != that.prefetchCount) {
                        return false;
                    } else {
                        return this.global == that.global;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.prefetchSize;
                result = 31 * result + this.prefetchCount;
                result = 31 * result + (this.global ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(prefetch-size=").append(this.prefetchSize).append(", prefetch-count=").append(this.prefetchCount).append(", global=").append(this.global).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeLong(this.prefetchSize);
                writer.writeShort(this.prefetchCount);
                writer.writeBit(this.global);
            }
        }
    }

    public static class Queue {
        public static final int INDEX = 50;

        public Queue() {
        }

        public static class UnbindOk extends Method implements com.rabbitmq.client.AMQP.Queue.UnbindOk {
            public static final int INDEX = 51;

            public UnbindOk() {
            }

            public UnbindOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 50;
            }

            public int protocolMethodId() {
                return 51;
            }

            public String protocolMethodName() {
                return "queue.unbind-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Unbind extends Method implements com.rabbitmq.client.AMQP.Queue.Unbind {
            public static final int INDEX = 50;
            private final int ticket;
            private final String queue;
            private final String exchange;
            private final String routingKey;
            private final Map<String, Object> arguments;

            public int getTicket() {
                return this.ticket;
            }

            public String getQueue() {
                return this.queue;
            }

            public String getExchange() {
                return this.exchange;
            }

            public String getRoutingKey() {
                return this.routingKey;
            }

            public Map<String, Object> getArguments() {
                return this.arguments;
            }

            public Unbind(int ticket, String queue, String exchange, String routingKey, Map<String, Object> arguments) {
                if (exchange == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else if (queue == null) {
                    throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
                } else if (routingKey == null) {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                } else {
                    this.ticket = ticket;
                    this.queue = queue;
                    this.exchange = exchange;
                    this.routingKey = routingKey;
                    this.arguments = arguments == null ? null : Collections.unmodifiableMap(new HashMap(arguments));
                }
            }

            public Unbind(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readShortstr(), rdr.readShortstr(), rdr.readTable());
            }

            public int protocolClassId() {
                return 50;
            }

            public int protocolMethodId() {
                return 50;
            }

            public String protocolMethodName() {
                return "queue.unbind";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Queue.Unbind that = (AMQImpl.Queue.Unbind)o;
                    if (this.ticket != that.ticket) {
                        return false;
                    } else {
                        label60: {
                            if (this.queue != null) {
                                if (this.queue.equals(that.queue)) {
                                    break label60;
                                }
                            } else if (that.queue == null) {
                                break label60;
                            }

                            return false;
                        }

                        if (this.exchange != null) {
                            if (!this.exchange.equals(that.exchange)) {
                                return false;
                            }
                        } else if (that.exchange != null) {
                            return false;
                        }

                        if (this.routingKey != null) {
                            if (!this.routingKey.equals(that.routingKey)) {
                                return false;
                            }
                        } else if (that.routingKey != null) {
                            return false;
                        }

                        if (this.arguments != null) {
                            if (!this.arguments.equals(that.arguments)) {
                                return false;
                            }
                        } else if (that.arguments != null) {
                            return false;
                        }

                        return true;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.ticket;
                result = 31 * result + (this.queue != null ? this.queue.hashCode() : 0);
                result = 31 * result + (this.exchange != null ? this.exchange.hashCode() : 0);
                result = 31 * result + (this.routingKey != null ? this.routingKey.hashCode() : 0);
                result = 31 * result + (this.arguments != null ? this.arguments.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(ticket=").append(this.ticket).append(", queue=").append(this.queue).append(", exchange=").append(this.exchange).append(", routing-key=").append(this.routingKey).append(", arguments=").append(this.arguments).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.ticket);
                writer.writeShortstr(this.queue);
                writer.writeShortstr(this.exchange);
                writer.writeShortstr(this.routingKey);
                writer.writeTable(this.arguments);
            }
        }

        public static class DeleteOk extends Method implements com.rabbitmq.client.AMQP.Queue.DeleteOk {
            public static final int INDEX = 41;
            private final int messageCount;

            public int getMessageCount() {
                return this.messageCount;
            }

            public DeleteOk(int messageCount) {
                this.messageCount = messageCount;
            }

            public DeleteOk(MethodArgumentReader rdr) throws IOException {
                this(rdr.readLong());
            }

            public int protocolClassId() {
                return 50;
            }

            public int protocolMethodId() {
                return 41;
            }

            public String protocolMethodName() {
                return "queue.delete-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Queue.DeleteOk that = (AMQImpl.Queue.DeleteOk)o;
                    return this.messageCount == that.messageCount;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.messageCount;
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(message-count=").append(this.messageCount).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeLong(this.messageCount);
            }
        }

        public static class Delete extends Method implements com.rabbitmq.client.AMQP.Queue.Delete {
            public static final int INDEX = 40;
            private final int ticket;
            private final String queue;
            private final boolean ifUnused;
            private final boolean ifEmpty;
            private final boolean nowait;

            public int getTicket() {
                return this.ticket;
            }

            public String getQueue() {
                return this.queue;
            }

            public boolean getIfUnused() {
                return this.ifUnused;
            }

            public boolean getIfEmpty() {
                return this.ifEmpty;
            }

            public boolean getNowait() {
                return this.nowait;
            }

            public Delete(int ticket, String queue, boolean ifUnused, boolean ifEmpty, boolean nowait) {
                if (queue == null) {
                    throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
                } else {
                    this.ticket = ticket;
                    this.queue = queue;
                    this.ifUnused = ifUnused;
                    this.ifEmpty = ifEmpty;
                    this.nowait = nowait;
                }
            }

            public Delete(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readBit(), rdr.readBit(), rdr.readBit());
            }

            public int protocolClassId() {
                return 50;
            }

            public int protocolMethodId() {
                return 40;
            }

            public String protocolMethodName() {
                return "queue.delete";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Queue.Delete that = (AMQImpl.Queue.Delete)o;
                    if (this.ticket != that.ticket) {
                        return false;
                    } else {
                        if (this.queue != null) {
                            if (!this.queue.equals(that.queue)) {
                                return false;
                            }
                        } else if (that.queue != null) {
                            return false;
                        }

                        if (this.ifUnused != that.ifUnused) {
                            return false;
                        } else if (this.ifEmpty != that.ifEmpty) {
                            return false;
                        } else if (this.nowait != that.nowait) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.ticket;
                result = 31 * result + (this.queue != null ? this.queue.hashCode() : 0);
                result = 31 * result + (this.ifUnused ? 1 : 0);
                result = 31 * result + (this.ifEmpty ? 1 : 0);
                result = 31 * result + (this.nowait ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(ticket=").append(this.ticket).append(", queue=").append(this.queue).append(", if-unused=").append(this.ifUnused).append(", if-empty=").append(this.ifEmpty).append(", nowait=").append(this.nowait).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.ticket);
                writer.writeShortstr(this.queue);
                writer.writeBit(this.ifUnused);
                writer.writeBit(this.ifEmpty);
                writer.writeBit(this.nowait);
            }
        }

        public static class PurgeOk extends Method implements com.rabbitmq.client.AMQP.Queue.PurgeOk {
            public static final int INDEX = 31;
            private final int messageCount;

            public int getMessageCount() {
                return this.messageCount;
            }

            public PurgeOk(int messageCount) {
                this.messageCount = messageCount;
            }

            public PurgeOk(MethodArgumentReader rdr) throws IOException {
                this(rdr.readLong());
            }

            public int protocolClassId() {
                return 50;
            }

            public int protocolMethodId() {
                return 31;
            }

            public String protocolMethodName() {
                return "queue.purge-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Queue.PurgeOk that = (AMQImpl.Queue.PurgeOk)o;
                    return this.messageCount == that.messageCount;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.messageCount;
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(message-count=").append(this.messageCount).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeLong(this.messageCount);
            }
        }

        public static class Purge extends Method implements com.rabbitmq.client.AMQP.Queue.Purge {
            public static final int INDEX = 30;
            private final int ticket;
            private final String queue;
            private final boolean nowait;

            public int getTicket() {
                return this.ticket;
            }

            public String getQueue() {
                return this.queue;
            }

            public boolean getNowait() {
                return this.nowait;
            }

            public Purge(int ticket, String queue, boolean nowait) {
                if (queue == null) {
                    throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
                } else {
                    this.ticket = ticket;
                    this.queue = queue;
                    this.nowait = nowait;
                }
            }

            public Purge(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readBit());
            }

            public int protocolClassId() {
                return 50;
            }

            public int protocolMethodId() {
                return 30;
            }

            public String protocolMethodName() {
                return "queue.purge";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Queue.Purge that = (AMQImpl.Queue.Purge)o;
                    if (this.ticket != that.ticket) {
                        return false;
                    } else {
                        if (this.queue != null) {
                            if (this.queue.equals(that.queue)) {
                                return this.nowait == that.nowait;
                            }
                        } else if (that.queue == null) {
                            return this.nowait == that.nowait;
                        }

                        return false;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.ticket;
                result = 31 * result + (this.queue != null ? this.queue.hashCode() : 0);
                result = 31 * result + (this.nowait ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(ticket=").append(this.ticket).append(", queue=").append(this.queue).append(", nowait=").append(this.nowait).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.ticket);
                writer.writeShortstr(this.queue);
                writer.writeBit(this.nowait);
            }
        }

        public static class BindOk extends Method implements com.rabbitmq.client.AMQP.Queue.BindOk {
            public static final int INDEX = 21;

            public BindOk() {
            }

            public BindOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 50;
            }

            public int protocolMethodId() {
                return 21;
            }

            public String protocolMethodName() {
                return "queue.bind-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Bind extends Method implements com.rabbitmq.client.AMQP.Queue.Bind {
            public static final int INDEX = 20;
            private final int ticket;
            private final String queue;
            private final String exchange;
            private final String routingKey;
            private final boolean nowait;
            private final Map<String, Object> arguments;

            public int getTicket() {
                return this.ticket;
            }

            public String getQueue() {
                return this.queue;
            }

            public String getExchange() {
                return this.exchange;
            }

            public String getRoutingKey() {
                return this.routingKey;
            }

            public boolean getNowait() {
                return this.nowait;
            }

            public Map<String, Object> getArguments() {
                return this.arguments;
            }

            public Bind(int ticket, String queue, String exchange, String routingKey, boolean nowait, Map<String, Object> arguments) {
                if (exchange == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else if (queue == null) {
                    throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
                } else if (routingKey == null) {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                } else {
                    this.ticket = ticket;
                    this.queue = queue;
                    this.exchange = exchange;
                    this.routingKey = routingKey;
                    this.nowait = nowait;
                    this.arguments = arguments == null ? null : Collections.unmodifiableMap(new HashMap(arguments));
                }
            }

            public Bind(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readShortstr(), rdr.readShortstr(), rdr.readBit(), rdr.readTable());
            }

            public int protocolClassId() {
                return 50;
            }

            public int protocolMethodId() {
                return 20;
            }

            public String protocolMethodName() {
                return "queue.bind";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Queue.Bind that = (AMQImpl.Queue.Bind)o;
                    if (this.ticket != that.ticket) {
                        return false;
                    } else {
                        label64: {
                            if (this.queue != null) {
                                if (this.queue.equals(that.queue)) {
                                    break label64;
                                }
                            } else if (that.queue == null) {
                                break label64;
                            }

                            return false;
                        }

                        if (this.exchange != null) {
                            if (!this.exchange.equals(that.exchange)) {
                                return false;
                            }
                        } else if (that.exchange != null) {
                            return false;
                        }

                        if (this.routingKey != null) {
                            if (!this.routingKey.equals(that.routingKey)) {
                                return false;
                            }
                        } else if (that.routingKey != null) {
                            return false;
                        }

                        if (this.nowait != that.nowait) {
                            return false;
                        } else {
                            if (this.arguments != null) {
                                if (!this.arguments.equals(that.arguments)) {
                                    return false;
                                }
                            } else if (that.arguments != null) {
                                return false;
                            }

                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.ticket;
                result = 31 * result + (this.queue != null ? this.queue.hashCode() : 0);
                result = 31 * result + (this.exchange != null ? this.exchange.hashCode() : 0);
                result = 31 * result + (this.routingKey != null ? this.routingKey.hashCode() : 0);
                result = 31 * result + (this.nowait ? 1 : 0);
                result = 31 * result + (this.arguments != null ? this.arguments.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(ticket=").append(this.ticket).append(", queue=").append(this.queue).append(", exchange=").append(this.exchange).append(", routing-key=").append(this.routingKey).append(", nowait=").append(this.nowait).append(", arguments=").append(this.arguments).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.ticket);
                writer.writeShortstr(this.queue);
                writer.writeShortstr(this.exchange);
                writer.writeShortstr(this.routingKey);
                writer.writeBit(this.nowait);
                writer.writeTable(this.arguments);
            }
        }

        public static class DeclareOk extends Method implements com.rabbitmq.client.AMQP.Queue.DeclareOk {
            public static final int INDEX = 11;
            private final String queue;
            private final int messageCount;
            private final int consumerCount;

            public String getQueue() {
                return this.queue;
            }

            public int getMessageCount() {
                return this.messageCount;
            }

            public int getConsumerCount() {
                return this.consumerCount;
            }

            public DeclareOk(String queue, int messageCount, int consumerCount) {
                if (queue == null) {
                    throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
                } else {
                    this.queue = queue;
                    this.messageCount = messageCount;
                    this.consumerCount = consumerCount;
                }
            }

            public DeclareOk(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShortstr(), rdr.readLong(), rdr.readLong());
            }

            public int protocolClassId() {
                return 50;
            }

            public int protocolMethodId() {
                return 11;
            }

            public String protocolMethodName() {
                return "queue.declare-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Queue.DeclareOk that;
                    label29: {
                        that = (AMQImpl.Queue.DeclareOk)o;
                        if (this.queue != null) {
                            if (this.queue.equals(that.queue)) {
                                break label29;
                            }
                        } else if (that.queue == null) {
                            break label29;
                        }

                        return false;
                    }

                    if (this.messageCount != that.messageCount) {
                        return false;
                    } else {
                        return this.consumerCount == that.consumerCount;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.queue != null ? this.queue.hashCode() : 0);
                result = 31 * result + this.messageCount;
                result = 31 * result + this.consumerCount;
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(queue=").append(this.queue).append(", message-count=").append(this.messageCount).append(", consumer-count=").append(this.consumerCount).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShortstr(this.queue);
                writer.writeLong(this.messageCount);
                writer.writeLong(this.consumerCount);
            }
        }

        public static class Declare extends Method implements com.rabbitmq.client.AMQP.Queue.Declare {
            public static final int INDEX = 10;
            private final int ticket;
            private final String queue;
            private final boolean passive;
            private final boolean durable;
            private final boolean exclusive;
            private final boolean autoDelete;
            private final boolean nowait;
            private final Map<String, Object> arguments;

            public int getTicket() {
                return this.ticket;
            }

            public String getQueue() {
                return this.queue;
            }

            public boolean getPassive() {
                return this.passive;
            }

            public boolean getDurable() {
                return this.durable;
            }

            public boolean getExclusive() {
                return this.exclusive;
            }

            public boolean getAutoDelete() {
                return this.autoDelete;
            }

            public boolean getNowait() {
                return this.nowait;
            }

            public Map<String, Object> getArguments() {
                return this.arguments;
            }

            public Declare(int ticket, String queue, boolean passive, boolean durable, boolean exclusive, boolean autoDelete, boolean nowait, Map<String, Object> arguments) {
                if (queue == null) {
                    throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
                } else {
                    this.ticket = ticket;
                    this.queue = queue;
                    this.passive = passive;
                    this.durable = durable;
                    this.exclusive = exclusive;
                    this.autoDelete = autoDelete;
                    this.nowait = nowait;
                    this.arguments = arguments == null ? null : Collections.unmodifiableMap(new HashMap(arguments));
                }
            }

            public Declare(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readBit(), rdr.readBit(), rdr.readBit(), rdr.readBit(), rdr.readBit(), rdr.readTable());
            }

            public int protocolClassId() {
                return 50;
            }

            public int protocolMethodId() {
                return 10;
            }

            public String protocolMethodName() {
                return "queue.declare";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Queue.Declare that = (AMQImpl.Queue.Declare)o;
                    if (this.ticket != that.ticket) {
                        return false;
                    } else {
                        label56: {
                            if (this.queue != null) {
                                if (this.queue.equals(that.queue)) {
                                    break label56;
                                }
                            } else if (that.queue == null) {
                                break label56;
                            }

                            return false;
                        }

                        if (this.passive != that.passive) {
                            return false;
                        } else if (this.durable != that.durable) {
                            return false;
                        } else if (this.exclusive != that.exclusive) {
                            return false;
                        } else if (this.autoDelete != that.autoDelete) {
                            return false;
                        } else if (this.nowait != that.nowait) {
                            return false;
                        } else {
                            if (this.arguments != null) {
                                if (!this.arguments.equals(that.arguments)) {
                                    return false;
                                }
                            } else if (that.arguments != null) {
                                return false;
                            }

                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.ticket;
                result = 31 * result + (this.queue != null ? this.queue.hashCode() : 0);
                result = 31 * result + (this.passive ? 1 : 0);
                result = 31 * result + (this.durable ? 1 : 0);
                result = 31 * result + (this.exclusive ? 1 : 0);
                result = 31 * result + (this.autoDelete ? 1 : 0);
                result = 31 * result + (this.nowait ? 1 : 0);
                result = 31 * result + (this.arguments != null ? this.arguments.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(ticket=").append(this.ticket).append(", queue=").append(this.queue).append(", passive=").append(this.passive).append(", durable=").append(this.durable).append(", exclusive=").append(this.exclusive).append(", auto-delete=").append(this.autoDelete).append(", nowait=").append(this.nowait).append(", arguments=").append(this.arguments).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.ticket);
                writer.writeShortstr(this.queue);
                writer.writeBit(this.passive);
                writer.writeBit(this.durable);
                writer.writeBit(this.exclusive);
                writer.writeBit(this.autoDelete);
                writer.writeBit(this.nowait);
                writer.writeTable(this.arguments);
            }
        }
    }

    public static class Exchange {
        public static final int INDEX = 40;

        public Exchange() {
        }

        public static class UnbindOk extends Method implements com.rabbitmq.client.AMQP.Exchange.UnbindOk {
            public static final int INDEX = 51;

            public UnbindOk() {
            }

            public UnbindOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 40;
            }

            public int protocolMethodId() {
                return 51;
            }

            public String protocolMethodName() {
                return "exchange.unbind-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Unbind extends Method implements com.rabbitmq.client.AMQP.Exchange.Unbind {
            public static final int INDEX = 40;
            private final int ticket;
            private final String destination;
            private final String source;
            private final String routingKey;
            private final boolean nowait;
            private final Map<String, Object> arguments;

            public int getTicket() {
                return this.ticket;
            }

            public String getDestination() {
                return this.destination;
            }

            public String getSource() {
                return this.source;
            }

            public String getRoutingKey() {
                return this.routingKey;
            }

            public boolean getNowait() {
                return this.nowait;
            }

            public Map<String, Object> getArguments() {
                return this.arguments;
            }

            public Unbind(int ticket, String destination, String source, String routingKey, boolean nowait, Map<String, Object> arguments) {
                if (destination == null) {
                    throw new IllegalStateException("Invalid configuration: 'destination' must be non-null.");
                } else if (routingKey == null) {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                } else if (source == null) {
                    throw new IllegalStateException("Invalid configuration: 'source' must be non-null.");
                } else {
                    this.ticket = ticket;
                    this.destination = destination;
                    this.source = source;
                    this.routingKey = routingKey;
                    this.nowait = nowait;
                    this.arguments = arguments == null ? null : Collections.unmodifiableMap(new HashMap(arguments));
                }
            }

            public Unbind(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readShortstr(), rdr.readShortstr(), rdr.readBit(), rdr.readTable());
            }

            public int protocolClassId() {
                return 40;
            }

            public int protocolMethodId() {
                return 40;
            }

            public String protocolMethodName() {
                return "exchange.unbind";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Exchange.Unbind that = (AMQImpl.Exchange.Unbind)o;
                    if (this.ticket != that.ticket) {
                        return false;
                    } else {
                        label64: {
                            if (this.destination != null) {
                                if (this.destination.equals(that.destination)) {
                                    break label64;
                                }
                            } else if (that.destination == null) {
                                break label64;
                            }

                            return false;
                        }

                        if (this.source != null) {
                            if (!this.source.equals(that.source)) {
                                return false;
                            }
                        } else if (that.source != null) {
                            return false;
                        }

                        if (this.routingKey != null) {
                            if (!this.routingKey.equals(that.routingKey)) {
                                return false;
                            }
                        } else if (that.routingKey != null) {
                            return false;
                        }

                        if (this.nowait != that.nowait) {
                            return false;
                        } else {
                            if (this.arguments != null) {
                                if (!this.arguments.equals(that.arguments)) {
                                    return false;
                                }
                            } else if (that.arguments != null) {
                                return false;
                            }

                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.ticket;
                result = 31 * result + (this.destination != null ? this.destination.hashCode() : 0);
                result = 31 * result + (this.source != null ? this.source.hashCode() : 0);
                result = 31 * result + (this.routingKey != null ? this.routingKey.hashCode() : 0);
                result = 31 * result + (this.nowait ? 1 : 0);
                result = 31 * result + (this.arguments != null ? this.arguments.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(ticket=").append(this.ticket).append(", destination=").append(this.destination).append(", source=").append(this.source).append(", routing-key=").append(this.routingKey).append(", nowait=").append(this.nowait).append(", arguments=").append(this.arguments).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.ticket);
                writer.writeShortstr(this.destination);
                writer.writeShortstr(this.source);
                writer.writeShortstr(this.routingKey);
                writer.writeBit(this.nowait);
                writer.writeTable(this.arguments);
            }
        }

        public static class BindOk extends Method implements com.rabbitmq.client.AMQP.Exchange.BindOk {
            public static final int INDEX = 31;

            public BindOk() {
            }

            public BindOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 40;
            }

            public int protocolMethodId() {
                return 31;
            }

            public String protocolMethodName() {
                return "exchange.bind-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Bind extends Method implements com.rabbitmq.client.AMQP.Exchange.Bind {
            public static final int INDEX = 30;
            private final int ticket;
            private final String destination;
            private final String source;
            private final String routingKey;
            private final boolean nowait;
            private final Map<String, Object> arguments;

            public int getTicket() {
                return this.ticket;
            }

            public String getDestination() {
                return this.destination;
            }

            public String getSource() {
                return this.source;
            }

            public String getRoutingKey() {
                return this.routingKey;
            }

            public boolean getNowait() {
                return this.nowait;
            }

            public Map<String, Object> getArguments() {
                return this.arguments;
            }

            public Bind(int ticket, String destination, String source, String routingKey, boolean nowait, Map<String, Object> arguments) {
                if (destination == null) {
                    throw new IllegalStateException("Invalid configuration: 'destination' must be non-null.");
                } else if (routingKey == null) {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                } else if (source == null) {
                    throw new IllegalStateException("Invalid configuration: 'source' must be non-null.");
                } else {
                    this.ticket = ticket;
                    this.destination = destination;
                    this.source = source;
                    this.routingKey = routingKey;
                    this.nowait = nowait;
                    this.arguments = arguments == null ? null : Collections.unmodifiableMap(new HashMap(arguments));
                }
            }

            public Bind(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readShortstr(), rdr.readShortstr(), rdr.readBit(), rdr.readTable());
            }

            public int protocolClassId() {
                return 40;
            }

            public int protocolMethodId() {
                return 30;
            }

            public String protocolMethodName() {
                return "exchange.bind";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Exchange.Bind that = (AMQImpl.Exchange.Bind)o;
                    if (this.ticket != that.ticket) {
                        return false;
                    } else {
                        label64: {
                            if (this.destination != null) {
                                if (this.destination.equals(that.destination)) {
                                    break label64;
                                }
                            } else if (that.destination == null) {
                                break label64;
                            }

                            return false;
                        }

                        if (this.source != null) {
                            if (!this.source.equals(that.source)) {
                                return false;
                            }
                        } else if (that.source != null) {
                            return false;
                        }

                        if (this.routingKey != null) {
                            if (!this.routingKey.equals(that.routingKey)) {
                                return false;
                            }
                        } else if (that.routingKey != null) {
                            return false;
                        }

                        if (this.nowait != that.nowait) {
                            return false;
                        } else {
                            if (this.arguments != null) {
                                if (!this.arguments.equals(that.arguments)) {
                                    return false;
                                }
                            } else if (that.arguments != null) {
                                return false;
                            }

                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.ticket;
                result = 31 * result + (this.destination != null ? this.destination.hashCode() : 0);
                result = 31 * result + (this.source != null ? this.source.hashCode() : 0);
                result = 31 * result + (this.routingKey != null ? this.routingKey.hashCode() : 0);
                result = 31 * result + (this.nowait ? 1 : 0);
                result = 31 * result + (this.arguments != null ? this.arguments.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(ticket=").append(this.ticket).append(", destination=").append(this.destination).append(", source=").append(this.source).append(", routing-key=").append(this.routingKey).append(", nowait=").append(this.nowait).append(", arguments=").append(this.arguments).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.ticket);
                writer.writeShortstr(this.destination);
                writer.writeShortstr(this.source);
                writer.writeShortstr(this.routingKey);
                writer.writeBit(this.nowait);
                writer.writeTable(this.arguments);
            }
        }

        public static class DeleteOk extends Method implements com.rabbitmq.client.AMQP.Exchange.DeleteOk {
            public static final int INDEX = 21;

            public DeleteOk() {
            }

            public DeleteOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 40;
            }

            public int protocolMethodId() {
                return 21;
            }

            public String protocolMethodName() {
                return "exchange.delete-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Delete extends Method implements com.rabbitmq.client.AMQP.Exchange.Delete {
            public static final int INDEX = 20;
            private final int ticket;
            private final String exchange;
            private final boolean ifUnused;
            private final boolean nowait;

            public int getTicket() {
                return this.ticket;
            }

            public String getExchange() {
                return this.exchange;
            }

            public boolean getIfUnused() {
                return this.ifUnused;
            }

            public boolean getNowait() {
                return this.nowait;
            }

            public Delete(int ticket, String exchange, boolean ifUnused, boolean nowait) {
                if (exchange == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else {
                    this.ticket = ticket;
                    this.exchange = exchange;
                    this.ifUnused = ifUnused;
                    this.nowait = nowait;
                }
            }

            public Delete(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readBit(), rdr.readBit());
            }

            public int protocolClassId() {
                return 40;
            }

            public int protocolMethodId() {
                return 20;
            }

            public String protocolMethodName() {
                return "exchange.delete";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Exchange.Delete that = (AMQImpl.Exchange.Delete)o;
                    if (this.ticket != that.ticket) {
                        return false;
                    } else {
                        label32: {
                            if (this.exchange != null) {
                                if (this.exchange.equals(that.exchange)) {
                                    break label32;
                                }
                            } else if (that.exchange == null) {
                                break label32;
                            }

                            return false;
                        }

                        if (this.ifUnused != that.ifUnused) {
                            return false;
                        } else {
                            return this.nowait == that.nowait;
                        }
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.ticket;
                result = 31 * result + (this.exchange != null ? this.exchange.hashCode() : 0);
                result = 31 * result + (this.ifUnused ? 1 : 0);
                result = 31 * result + (this.nowait ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(ticket=").append(this.ticket).append(", exchange=").append(this.exchange).append(", if-unused=").append(this.ifUnused).append(", nowait=").append(this.nowait).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.ticket);
                writer.writeShortstr(this.exchange);
                writer.writeBit(this.ifUnused);
                writer.writeBit(this.nowait);
            }
        }

        public static class DeclareOk extends Method implements com.rabbitmq.client.AMQP.Exchange.DeclareOk {
            public static final int INDEX = 11;

            public DeclareOk() {
            }

            public DeclareOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 40;
            }

            public int protocolMethodId() {
                return 11;
            }

            public String protocolMethodName() {
                return "exchange.declare-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Declare extends Method implements com.rabbitmq.client.AMQP.Exchange.Declare {
            public static final int INDEX = 10;
            private final int ticket;
            private final String exchange;
            private final String type;
            private final boolean passive;
            private final boolean durable;
            private final boolean autoDelete;
            private final boolean internal;
            private final boolean nowait;
            private final Map<String, Object> arguments;

            public int getTicket() {
                return this.ticket;
            }

            public String getExchange() {
                return this.exchange;
            }

            public String getType() {
                return this.type;
            }

            public boolean getPassive() {
                return this.passive;
            }

            public boolean getDurable() {
                return this.durable;
            }

            public boolean getAutoDelete() {
                return this.autoDelete;
            }

            public boolean getInternal() {
                return this.internal;
            }

            public boolean getNowait() {
                return this.nowait;
            }

            public Map<String, Object> getArguments() {
                return this.arguments;
            }

            public Declare(int ticket, String exchange, String type, boolean passive, boolean durable, boolean autoDelete, boolean internal, boolean nowait, Map<String, Object> arguments) {
                if (exchange == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else if (type == null) {
                    throw new IllegalStateException("Invalid configuration: 'type' must be non-null.");
                } else {
                    this.ticket = ticket;
                    this.exchange = exchange;
                    this.type = type;
                    this.passive = passive;
                    this.durable = durable;
                    this.autoDelete = autoDelete;
                    this.internal = internal;
                    this.nowait = nowait;
                    this.arguments = arguments == null ? null : Collections.unmodifiableMap(new HashMap(arguments));
                }
            }

            public Declare(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readShortstr(), rdr.readBit(), rdr.readBit(), rdr.readBit(), rdr.readBit(), rdr.readBit(), rdr.readTable());
            }

            public int protocolClassId() {
                return 40;
            }

            public int protocolMethodId() {
                return 10;
            }

            public String protocolMethodName() {
                return "exchange.declare";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Exchange.Declare that = (AMQImpl.Exchange.Declare)o;
                    if (this.ticket != that.ticket) {
                        return false;
                    } else {
                        if (this.exchange != null) {
                            if (!this.exchange.equals(that.exchange)) {
                                return false;
                            }
                        } else if (that.exchange != null) {
                            return false;
                        }

                        if (this.type != null) {
                            if (!this.type.equals(that.type)) {
                                return false;
                            }
                        } else if (that.type != null) {
                            return false;
                        }

                        if (this.passive != that.passive) {
                            return false;
                        } else if (this.durable != that.durable) {
                            return false;
                        } else if (this.autoDelete != that.autoDelete) {
                            return false;
                        } else if (this.internal != that.internal) {
                            return false;
                        } else if (this.nowait != that.nowait) {
                            return false;
                        } else {
                            if (this.arguments != null) {
                                if (!this.arguments.equals(that.arguments)) {
                                    return false;
                                }
                            } else if (that.arguments != null) {
                                return false;
                            }

                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.ticket;
                result = 31 * result + (this.exchange != null ? this.exchange.hashCode() : 0);
                result = 31 * result + (this.type != null ? this.type.hashCode() : 0);
                result = 31 * result + (this.passive ? 1 : 0);
                result = 31 * result + (this.durable ? 1 : 0);
                result = 31 * result + (this.autoDelete ? 1 : 0);
                result = 31 * result + (this.internal ? 1 : 0);
                result = 31 * result + (this.nowait ? 1 : 0);
                result = 31 * result + (this.arguments != null ? this.arguments.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(ticket=").append(this.ticket).append(", exchange=").append(this.exchange).append(", type=").append(this.type).append(", passive=").append(this.passive).append(", durable=").append(this.durable).append(", auto-delete=").append(this.autoDelete).append(", internal=").append(this.internal).append(", nowait=").append(this.nowait).append(", arguments=").append(this.arguments).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.ticket);
                writer.writeShortstr(this.exchange);
                writer.writeShortstr(this.type);
                writer.writeBit(this.passive);
                writer.writeBit(this.durable);
                writer.writeBit(this.autoDelete);
                writer.writeBit(this.internal);
                writer.writeBit(this.nowait);
                writer.writeTable(this.arguments);
            }
        }
    }

    public static class Access {
        public static final int INDEX = 30;

        public Access() {
        }

        public static class RequestOk extends Method implements com.rabbitmq.client.AMQP.Access.RequestOk {
            public static final int INDEX = 11;
            private final int ticket;

            public int getTicket() {
                return this.ticket;
            }

            public RequestOk(int ticket) {
                this.ticket = ticket;
            }

            public RequestOk(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort());
            }

            public int protocolClassId() {
                return 30;
            }

            public int protocolMethodId() {
                return 11;
            }

            public String protocolMethodName() {
                return "access.request-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Access.RequestOk that = (AMQImpl.Access.RequestOk)o;
                    return this.ticket == that.ticket;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.ticket;
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(ticket=").append(this.ticket).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.ticket);
            }
        }

        public static class Request extends Method implements com.rabbitmq.client.AMQP.Access.Request {
            public static final int INDEX = 10;
            private final String realm;
            private final boolean exclusive;
            private final boolean passive;
            private final boolean active;
            private final boolean write;
            private final boolean read;

            public String getRealm() {
                return this.realm;
            }

            public boolean getExclusive() {
                return this.exclusive;
            }

            public boolean getPassive() {
                return this.passive;
            }

            public boolean getActive() {
                return this.active;
            }

            public boolean getWrite() {
                return this.write;
            }

            public boolean getRead() {
                return this.read;
            }

            public Request(String realm, boolean exclusive, boolean passive, boolean active, boolean write, boolean read) {
                if (realm == null) {
                    throw new IllegalStateException("Invalid configuration: 'realm' must be non-null.");
                } else {
                    this.realm = realm;
                    this.exclusive = exclusive;
                    this.passive = passive;
                    this.active = active;
                    this.write = write;
                    this.read = read;
                }
            }

            public Request(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShortstr(), rdr.readBit(), rdr.readBit(), rdr.readBit(), rdr.readBit(), rdr.readBit());
            }

            public int protocolClassId() {
                return 30;
            }

            public int protocolMethodId() {
                return 10;
            }

            public String protocolMethodName() {
                return "access.request";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Access.Request that;
                    label41: {
                        that = (AMQImpl.Access.Request)o;
                        if (this.realm != null) {
                            if (this.realm.equals(that.realm)) {
                                break label41;
                            }
                        } else if (that.realm == null) {
                            break label41;
                        }

                        return false;
                    }

                    if (this.exclusive != that.exclusive) {
                        return false;
                    } else if (this.passive != that.passive) {
                        return false;
                    } else if (this.active != that.active) {
                        return false;
                    } else if (this.write != that.write) {
                        return false;
                    } else {
                        return this.read == that.read;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.realm != null ? this.realm.hashCode() : 0);
                result = 31 * result + (this.exclusive ? 1 : 0);
                result = 31 * result + (this.passive ? 1 : 0);
                result = 31 * result + (this.active ? 1 : 0);
                result = 31 * result + (this.write ? 1 : 0);
                result = 31 * result + (this.read ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(realm=").append(this.realm).append(", exclusive=").append(this.exclusive).append(", passive=").append(this.passive).append(", active=").append(this.active).append(", write=").append(this.write).append(", read=").append(this.read).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShortstr(this.realm);
                writer.writeBit(this.exclusive);
                writer.writeBit(this.passive);
                writer.writeBit(this.active);
                writer.writeBit(this.write);
                writer.writeBit(this.read);
            }
        }
    }

    public static class Channel {
        public static final int INDEX = 20;

        public Channel() {
        }

        public static class CloseOk extends Method implements com.rabbitmq.client.AMQP.Channel.CloseOk {
            public static final int INDEX = 41;

            public CloseOk() {
            }

            public CloseOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 20;
            }

            public int protocolMethodId() {
                return 41;
            }

            public String protocolMethodName() {
                return "channel.close-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Close extends Method implements com.rabbitmq.client.AMQP.Channel.Close {
            public static final int INDEX = 40;
            private final int replyCode;
            private final String replyText;
            private final int classId;
            private final int methodId;

            public int getReplyCode() {
                return this.replyCode;
            }

            public String getReplyText() {
                return this.replyText;
            }

            public int getClassId() {
                return this.classId;
            }

            public int getMethodId() {
                return this.methodId;
            }

            public Close(int replyCode, String replyText, int classId, int methodId) {
                if (replyText == null) {
                    throw new IllegalStateException("Invalid configuration: 'replyText' must be non-null.");
                } else {
                    this.replyCode = replyCode;
                    this.replyText = replyText;
                    this.classId = classId;
                    this.methodId = methodId;
                }
            }

            public Close(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readShort(), rdr.readShort());
            }

            public int protocolClassId() {
                return 20;
            }

            public int protocolMethodId() {
                return 40;
            }

            public String protocolMethodName() {
                return "channel.close";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Channel.Close that = (AMQImpl.Channel.Close)o;
                    if (this.replyCode != that.replyCode) {
                        return false;
                    } else {
                        label32: {
                            if (this.replyText != null) {
                                if (this.replyText.equals(that.replyText)) {
                                    break label32;
                                }
                            } else if (that.replyText == null) {
                                break label32;
                            }

                            return false;
                        }

                        if (this.classId != that.classId) {
                            return false;
                        } else {
                            return this.methodId == that.methodId;
                        }
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.replyCode;
                result = 31 * result + (this.replyText != null ? this.replyText.hashCode() : 0);
                result = 31 * result + this.classId;
                result = 31 * result + this.methodId;
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(reply-code=").append(this.replyCode).append(", reply-text=").append(this.replyText).append(", class-id=").append(this.classId).append(", method-id=").append(this.methodId).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.replyCode);
                writer.writeShortstr(this.replyText);
                writer.writeShort(this.classId);
                writer.writeShort(this.methodId);
            }
        }

        public static class FlowOk extends Method implements com.rabbitmq.client.AMQP.Channel.FlowOk {
            public static final int INDEX = 21;
            private final boolean active;

            public boolean getActive() {
                return this.active;
            }

            public FlowOk(boolean active) {
                this.active = active;
            }

            public FlowOk(MethodArgumentReader rdr) throws IOException {
                this(rdr.readBit());
            }

            public int protocolClassId() {
                return 20;
            }

            public int protocolMethodId() {
                return 21;
            }

            public String protocolMethodName() {
                return "channel.flow-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Channel.FlowOk that = (AMQImpl.Channel.FlowOk)o;
                    return this.active == that.active;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.active ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(active=").append(this.active).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeBit(this.active);
            }
        }

        public static class Flow extends Method implements com.rabbitmq.client.AMQP.Channel.Flow {
            public static final int INDEX = 20;
            private final boolean active;

            public boolean getActive() {
                return this.active;
            }

            public Flow(boolean active) {
                this.active = active;
            }

            public Flow(MethodArgumentReader rdr) throws IOException {
                this(rdr.readBit());
            }

            public int protocolClassId() {
                return 20;
            }

            public int protocolMethodId() {
                return 20;
            }

            public String protocolMethodName() {
                return "channel.flow";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Channel.Flow that = (AMQImpl.Channel.Flow)o;
                    return this.active == that.active;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.active ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(active=").append(this.active).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeBit(this.active);
            }
        }

        public static class OpenOk extends Method implements com.rabbitmq.client.AMQP.Channel.OpenOk {
            public static final int INDEX = 11;
            private final LongString channelId;

            public LongString getChannelId() {
                return this.channelId;
            }

            public OpenOk(LongString channelId) {
                if (channelId == null) {
                    throw new IllegalStateException("Invalid configuration: 'channelId' must be non-null.");
                } else {
                    this.channelId = channelId;
                }
            }

            public OpenOk(MethodArgumentReader rdr) throws IOException {
                this(rdr.readLongstr());
            }

            public int protocolClassId() {
                return 20;
            }

            public int protocolMethodId() {
                return 11;
            }

            public String protocolMethodName() {
                return "channel.open-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Channel.OpenOk that = (AMQImpl.Channel.OpenOk)o;
                    if (this.channelId != null) {
                        if (!this.channelId.equals(that.channelId)) {
                            return false;
                        }
                    } else if (that.channelId != null) {
                        return false;
                    }

                    return true;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.channelId != null ? this.channelId.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(channel-id=").append(this.channelId).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeLongstr(this.channelId);
            }
        }

        public static class Open extends Method implements com.rabbitmq.client.AMQP.Channel.Open {
            public static final int INDEX = 10;
            private final String outOfBand;

            public String getOutOfBand() {
                return this.outOfBand;
            }

            public Open(String outOfBand) {
                if (outOfBand == null) {
                    throw new IllegalStateException("Invalid configuration: 'outOfBand' must be non-null.");
                } else {
                    this.outOfBand = outOfBand;
                }
            }

            public Open(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShortstr());
            }

            public int protocolClassId() {
                return 20;
            }

            public int protocolMethodId() {
                return 10;
            }

            public String protocolMethodName() {
                return "channel.open";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Channel.Open that = (AMQImpl.Channel.Open)o;
                    if (this.outOfBand != null) {
                        if (!this.outOfBand.equals(that.outOfBand)) {
                            return false;
                        }
                    } else if (that.outOfBand != null) {
                        return false;
                    }

                    return true;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.outOfBand != null ? this.outOfBand.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(out-of-band=").append(this.outOfBand).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShortstr(this.outOfBand);
            }
        }
    }

    public static class Connection {
        public static final int INDEX = 10;

        public Connection() {
        }

        public static class UpdateSecretOk extends Method implements com.rabbitmq.client.AMQP.Connection.UpdateSecretOk {
            public static final int INDEX = 71;

            public UpdateSecretOk() {
            }

            public UpdateSecretOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 10;
            }

            public int protocolMethodId() {
                return 71;
            }

            public String protocolMethodName() {
                return "connection.update-secret-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class UpdateSecret extends Method implements com.rabbitmq.client.AMQP.Connection.UpdateSecret {
            public static final int INDEX = 70;
            private final LongString newSecret;
            private final String reason;

            public LongString getNewSecret() {
                return this.newSecret;
            }

            public String getReason() {
                return this.reason;
            }

            public UpdateSecret(LongString newSecret, String reason) {
                if (newSecret == null) {
                    throw new IllegalStateException("Invalid configuration: 'newSecret' must be non-null.");
                } else if (reason == null) {
                    throw new IllegalStateException("Invalid configuration: 'reason' must be non-null.");
                } else {
                    this.newSecret = newSecret;
                    this.reason = reason;
                }
            }

            public UpdateSecret(MethodArgumentReader rdr) throws IOException {
                this(rdr.readLongstr(), rdr.readShortstr());
            }

            public int protocolClassId() {
                return 10;
            }

            public int protocolMethodId() {
                return 70;
            }

            public String protocolMethodName() {
                return "connection.update-secret";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Connection.UpdateSecret that = (AMQImpl.Connection.UpdateSecret)o;
                    if (this.newSecret != null) {
                        if (!this.newSecret.equals(that.newSecret)) {
                            return false;
                        }
                    } else if (that.newSecret != null) {
                        return false;
                    }

                    if (this.reason != null) {
                        if (this.reason.equals(that.reason)) {
                            return true;
                        }
                    } else if (that.reason == null) {
                        return true;
                    }

                    return false;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.newSecret != null ? this.newSecret.hashCode() : 0);
                result = 31 * result + (this.reason != null ? this.reason.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(new-secret=").append(this.newSecret).append(", reason=").append(this.reason).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeLongstr(this.newSecret);
                writer.writeShortstr(this.reason);
            }
        }

        public static class Unblocked extends Method implements com.rabbitmq.client.AMQP.Connection.Unblocked {
            public static final int INDEX = 61;

            public Unblocked() {
            }

            public Unblocked(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 10;
            }

            public int protocolMethodId() {
                return 61;
            }

            public String protocolMethodName() {
                return "connection.unblocked";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Blocked extends Method implements com.rabbitmq.client.AMQP.Connection.Blocked {
            public static final int INDEX = 60;
            private final String reason;

            public String getReason() {
                return this.reason;
            }

            public Blocked(String reason) {
                if (reason == null) {
                    throw new IllegalStateException("Invalid configuration: 'reason' must be non-null.");
                } else {
                    this.reason = reason;
                }
            }

            public Blocked(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShortstr());
            }

            public int protocolClassId() {
                return 10;
            }

            public int protocolMethodId() {
                return 60;
            }

            public String protocolMethodName() {
                return "connection.blocked";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Connection.Blocked that = (AMQImpl.Connection.Blocked)o;
                    if (this.reason != null) {
                        if (!this.reason.equals(that.reason)) {
                            return false;
                        }
                    } else if (that.reason != null) {
                        return false;
                    }

                    return true;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.reason != null ? this.reason.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(reason=").append(this.reason).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShortstr(this.reason);
            }
        }

        public static class CloseOk extends Method implements com.rabbitmq.client.AMQP.Connection.CloseOk {
            public static final int INDEX = 51;

            public CloseOk() {
            }

            public CloseOk(MethodArgumentReader rdr) throws IOException {
                this();
            }

            public int protocolClassId() {
                return 10;
            }

            public int protocolMethodId() {
                return 51;
            }

            public String protocolMethodName() {
                return "connection.close-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("()");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
            }
        }

        public static class Close extends Method implements com.rabbitmq.client.AMQP.Connection.Close {
            public static final int INDEX = 50;
            private final int replyCode;
            private final String replyText;
            private final int classId;
            private final int methodId;

            public int getReplyCode() {
                return this.replyCode;
            }

            public String getReplyText() {
                return this.replyText;
            }

            public int getClassId() {
                return this.classId;
            }

            public int getMethodId() {
                return this.methodId;
            }

            public Close(int replyCode, String replyText, int classId, int methodId) {
                if (replyText == null) {
                    throw new IllegalStateException("Invalid configuration: 'replyText' must be non-null.");
                } else {
                    this.replyCode = replyCode;
                    this.replyText = replyText;
                    this.classId = classId;
                    this.methodId = methodId;
                }
            }

            public Close(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readShortstr(), rdr.readShort(), rdr.readShort());
            }

            public int protocolClassId() {
                return 10;
            }

            public int protocolMethodId() {
                return 50;
            }

            public String protocolMethodName() {
                return "connection.close";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Connection.Close that = (AMQImpl.Connection.Close)o;
                    if (this.replyCode != that.replyCode) {
                        return false;
                    } else {
                        label32: {
                            if (this.replyText != null) {
                                if (this.replyText.equals(that.replyText)) {
                                    break label32;
                                }
                            } else if (that.replyText == null) {
                                break label32;
                            }

                            return false;
                        }

                        if (this.classId != that.classId) {
                            return false;
                        } else {
                            return this.methodId == that.methodId;
                        }
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.replyCode;
                result = 31 * result + (this.replyText != null ? this.replyText.hashCode() : 0);
                result = 31 * result + this.classId;
                result = 31 * result + this.methodId;
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(reply-code=").append(this.replyCode).append(", reply-text=").append(this.replyText).append(", class-id=").append(this.classId).append(", method-id=").append(this.methodId).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.replyCode);
                writer.writeShortstr(this.replyText);
                writer.writeShort(this.classId);
                writer.writeShort(this.methodId);
            }
        }

        public static class OpenOk extends Method implements com.rabbitmq.client.AMQP.Connection.OpenOk {
            public static final int INDEX = 41;
            private final String knownHosts;

            public String getKnownHosts() {
                return this.knownHosts;
            }

            public OpenOk(String knownHosts) {
                if (knownHosts == null) {
                    throw new IllegalStateException("Invalid configuration: 'knownHosts' must be non-null.");
                } else {
                    this.knownHosts = knownHosts;
                }
            }

            public OpenOk(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShortstr());
            }

            public int protocolClassId() {
                return 10;
            }

            public int protocolMethodId() {
                return 41;
            }

            public String protocolMethodName() {
                return "connection.open-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Connection.OpenOk that = (AMQImpl.Connection.OpenOk)o;
                    if (this.knownHosts != null) {
                        if (!this.knownHosts.equals(that.knownHosts)) {
                            return false;
                        }
                    } else if (that.knownHosts != null) {
                        return false;
                    }

                    return true;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.knownHosts != null ? this.knownHosts.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(known-hosts=").append(this.knownHosts).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShortstr(this.knownHosts);
            }
        }

        public static class Open extends Method implements com.rabbitmq.client.AMQP.Connection.Open {
            public static final int INDEX = 40;
            private final String virtualHost;
            private final String capabilities;
            private final boolean insist;

            public String getVirtualHost() {
                return this.virtualHost;
            }

            public String getCapabilities() {
                return this.capabilities;
            }

            public boolean getInsist() {
                return this.insist;
            }

            public Open(String virtualHost, String capabilities, boolean insist) {
                if (capabilities == null) {
                    throw new IllegalStateException("Invalid configuration: 'capabilities' must be non-null.");
                } else if (virtualHost == null) {
                    throw new IllegalStateException("Invalid configuration: 'virtualHost' must be non-null.");
                } else {
                    this.virtualHost = virtualHost;
                    this.capabilities = capabilities;
                    this.insist = insist;
                }
            }

            public Open(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShortstr(), rdr.readShortstr(), rdr.readBit());
            }

            public int protocolClassId() {
                return 10;
            }

            public int protocolMethodId() {
                return 40;
            }

            public String protocolMethodName() {
                return "connection.open";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Connection.Open that = (AMQImpl.Connection.Open)o;
                    if (this.virtualHost != null) {
                        if (!this.virtualHost.equals(that.virtualHost)) {
                            return false;
                        }
                    } else if (that.virtualHost != null) {
                        return false;
                    }

                    label30: {
                        if (this.capabilities != null) {
                            if (this.capabilities.equals(that.capabilities)) {
                                break label30;
                            }
                        } else if (that.capabilities == null) {
                            break label30;
                        }

                        return false;
                    }

                    if (this.insist != that.insist) {
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.virtualHost != null ? this.virtualHost.hashCode() : 0);
                result = 31 * result + (this.capabilities != null ? this.capabilities.hashCode() : 0);
                result = 31 * result + (this.insist ? 1 : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(virtual-host=").append(this.virtualHost).append(", capabilities=").append(this.capabilities).append(", insist=").append(this.insist).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShortstr(this.virtualHost);
                writer.writeShortstr(this.capabilities);
                writer.writeBit(this.insist);
            }
        }

        public static class TuneOk extends Method implements com.rabbitmq.client.AMQP.Connection.TuneOk {
            public static final int INDEX = 31;
            private final int channelMax;
            private final int frameMax;
            private final int heartbeat;

            public int getChannelMax() {
                return this.channelMax;
            }

            public int getFrameMax() {
                return this.frameMax;
            }

            public int getHeartbeat() {
                return this.heartbeat;
            }

            public TuneOk(int channelMax, int frameMax, int heartbeat) {
                this.channelMax = channelMax;
                this.frameMax = frameMax;
                this.heartbeat = heartbeat;
            }

            public TuneOk(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readLong(), rdr.readShort());
            }

            public int protocolClassId() {
                return 10;
            }

            public int protocolMethodId() {
                return 31;
            }

            public String protocolMethodName() {
                return "connection.tune-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Connection.TuneOk that = (AMQImpl.Connection.TuneOk)o;
                    if (this.channelMax != that.channelMax) {
                        return false;
                    } else if (this.frameMax != that.frameMax) {
                        return false;
                    } else {
                        return this.heartbeat == that.heartbeat;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.channelMax;
                result = 31 * result + this.frameMax;
                result = 31 * result + this.heartbeat;
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(channel-max=").append(this.channelMax).append(", frame-max=").append(this.frameMax).append(", heartbeat=").append(this.heartbeat).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.channelMax);
                writer.writeLong(this.frameMax);
                writer.writeShort(this.heartbeat);
            }
        }

        public static class Tune extends Method implements com.rabbitmq.client.AMQP.Connection.Tune {
            public static final int INDEX = 30;
            private final int channelMax;
            private final int frameMax;
            private final int heartbeat;

            public int getChannelMax() {
                return this.channelMax;
            }

            public int getFrameMax() {
                return this.frameMax;
            }

            public int getHeartbeat() {
                return this.heartbeat;
            }

            public Tune(int channelMax, int frameMax, int heartbeat) {
                this.channelMax = channelMax;
                this.frameMax = frameMax;
                this.heartbeat = heartbeat;
            }

            public Tune(MethodArgumentReader rdr) throws IOException {
                this(rdr.readShort(), rdr.readLong(), rdr.readShort());
            }

            public int protocolClassId() {
                return 10;
            }

            public int protocolMethodId() {
                return 30;
            }

            public String protocolMethodName() {
                return "connection.tune";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Connection.Tune that = (AMQImpl.Connection.Tune)o;
                    if (this.channelMax != that.channelMax) {
                        return false;
                    } else if (this.frameMax != that.frameMax) {
                        return false;
                    } else {
                        return this.heartbeat == that.heartbeat;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.channelMax;
                result = 31 * result + this.frameMax;
                result = 31 * result + this.heartbeat;
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(channel-max=").append(this.channelMax).append(", frame-max=").append(this.frameMax).append(", heartbeat=").append(this.heartbeat).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeShort(this.channelMax);
                writer.writeLong(this.frameMax);
                writer.writeShort(this.heartbeat);
            }
        }

        public static class SecureOk extends Method implements com.rabbitmq.client.AMQP.Connection.SecureOk {
            public static final int INDEX = 21;
            private final LongString response;

            public LongString getResponse() {
                return this.response;
            }

            public SecureOk(LongString response) {
                if (response == null) {
                    throw new IllegalStateException("Invalid configuration: 'response' must be non-null.");
                } else {
                    this.response = response;
                }
            }

            public SecureOk(MethodArgumentReader rdr) throws IOException {
                this(rdr.readLongstr());
            }

            public int protocolClassId() {
                return 10;
            }

            public int protocolMethodId() {
                return 21;
            }

            public String protocolMethodName() {
                return "connection.secure-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Connection.SecureOk that = (AMQImpl.Connection.SecureOk)o;
                    if (this.response != null) {
                        if (!this.response.equals(that.response)) {
                            return false;
                        }
                    } else if (that.response != null) {
                        return false;
                    }

                    return true;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.response != null ? this.response.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(response=").append(this.response).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeLongstr(this.response);
            }
        }

        public static class Secure extends Method implements com.rabbitmq.client.AMQP.Connection.Secure {
            public static final int INDEX = 20;
            private final LongString challenge;

            public LongString getChallenge() {
                return this.challenge;
            }

            public Secure(LongString challenge) {
                if (challenge == null) {
                    throw new IllegalStateException("Invalid configuration: 'challenge' must be non-null.");
                } else {
                    this.challenge = challenge;
                }
            }

            public Secure(MethodArgumentReader rdr) throws IOException {
                this(rdr.readLongstr());
            }

            public int protocolClassId() {
                return 10;
            }

            public int protocolMethodId() {
                return 20;
            }

            public String protocolMethodName() {
                return "connection.secure";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Connection.Secure that = (AMQImpl.Connection.Secure)o;
                    if (this.challenge != null) {
                        if (!this.challenge.equals(that.challenge)) {
                            return false;
                        }
                    } else if (that.challenge != null) {
                        return false;
                    }

                    return true;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.challenge != null ? this.challenge.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(challenge=").append(this.challenge).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeLongstr(this.challenge);
            }
        }

        public static class StartOk extends Method implements com.rabbitmq.client.AMQP.Connection.StartOk {
            public static final int INDEX = 11;
            private final Map<String, Object> clientProperties;
            private final String mechanism;
            private final LongString response;
            private final String locale;

            public Map<String, Object> getClientProperties() {
                return this.clientProperties;
            }

            public String getMechanism() {
                return this.mechanism;
            }

            public LongString getResponse() {
                return this.response;
            }

            public String getLocale() {
                return this.locale;
            }

            public StartOk(Map<String, Object> clientProperties, String mechanism, LongString response, String locale) {
                if (locale == null) {
                    throw new IllegalStateException("Invalid configuration: 'locale' must be non-null.");
                } else if (mechanism == null) {
                    throw new IllegalStateException("Invalid configuration: 'mechanism' must be non-null.");
                } else if (response == null) {
                    throw new IllegalStateException("Invalid configuration: 'response' must be non-null.");
                } else {
                    this.clientProperties = clientProperties == null ? null : Collections.unmodifiableMap(new HashMap(clientProperties));
                    this.mechanism = mechanism;
                    this.response = response;
                    this.locale = locale;
                }
            }

            public StartOk(MethodArgumentReader rdr) throws IOException {
                this(rdr.readTable(), rdr.readShortstr(), rdr.readLongstr(), rdr.readShortstr());
            }

            public int protocolClassId() {
                return 10;
            }

            public int protocolMethodId() {
                return 11;
            }

            public String protocolMethodName() {
                return "connection.start-ok";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Connection.StartOk that;
                    label57: {
                        that = (AMQImpl.Connection.StartOk)o;
                        if (this.clientProperties != null) {
                            if (this.clientProperties.equals(that.clientProperties)) {
                                break label57;
                            }
                        } else if (that.clientProperties == null) {
                            break label57;
                        }

                        return false;
                    }

                    label50: {
                        if (this.mechanism != null) {
                            if (this.mechanism.equals(that.mechanism)) {
                                break label50;
                            }
                        } else if (that.mechanism == null) {
                            break label50;
                        }

                        return false;
                    }

                    if (this.response != null) {
                        if (!this.response.equals(that.response)) {
                            return false;
                        }
                    } else if (that.response != null) {
                        return false;
                    }

                    if (this.locale != null) {
                        if (!this.locale.equals(that.locale)) {
                            return false;
                        }
                    } else if (that.locale != null) {
                        return false;
                    }

                    return true;
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + (this.clientProperties != null ? this.clientProperties.hashCode() : 0);
                result = 31 * result + (this.mechanism != null ? this.mechanism.hashCode() : 0);
                result = 31 * result + (this.response != null ? this.response.hashCode() : 0);
                result = 31 * result + (this.locale != null ? this.locale.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(client-properties=").append(this.clientProperties).append(", mechanism=").append(this.mechanism).append(", response=").append(this.response).append(", locale=").append(this.locale).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeTable(this.clientProperties);
                writer.writeShortstr(this.mechanism);
                writer.writeLongstr(this.response);
                writer.writeShortstr(this.locale);
            }
        }

        public static class Start extends Method implements com.rabbitmq.client.AMQP.Connection.Start {
            public static final int INDEX = 10;
            private final int versionMajor;
            private final int versionMinor;
            private final Map<String, Object> serverProperties;
            private final LongString mechanisms;
            private final LongString locales;

            public int getVersionMajor() {
                return this.versionMajor;
            }

            public int getVersionMinor() {
                return this.versionMinor;
            }

            public Map<String, Object> getServerProperties() {
                return this.serverProperties;
            }

            public LongString getMechanisms() {
                return this.mechanisms;
            }

            public LongString getLocales() {
                return this.locales;
            }

            public Start(int versionMajor, int versionMinor, Map<String, Object> serverProperties, LongString mechanisms, LongString locales) {
                if (locales == null) {
                    throw new IllegalStateException("Invalid configuration: 'locales' must be non-null.");
                } else if (mechanisms == null) {
                    throw new IllegalStateException("Invalid configuration: 'mechanisms' must be non-null.");
                } else {
                    this.versionMajor = versionMajor;
                    this.versionMinor = versionMinor;
                    this.serverProperties = serverProperties == null ? null : Collections.unmodifiableMap(new HashMap(serverProperties));
                    this.mechanisms = mechanisms;
                    this.locales = locales;
                }
            }

            public Start(MethodArgumentReader rdr) throws IOException {
                this(rdr.readOctet(), rdr.readOctet(), rdr.readTable(), rdr.readLongstr(), rdr.readLongstr());
            }

            public int protocolClassId() {
                return 10;
            }

            public int protocolMethodId() {
                return 10;
            }

            public String protocolMethodName() {
                return "connection.start";
            }

            public boolean hasContent() {
                return false;
            }

            public Object visit(AMQImpl.MethodVisitor visitor) throws IOException {
                return visitor.visit(this);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                } else if (o != null && this.getClass() == o.getClass()) {
                    AMQImpl.Connection.Start that = (AMQImpl.Connection.Start)o;
                    if (this.versionMajor != that.versionMajor) {
                        return false;
                    } else if (this.versionMinor != that.versionMinor) {
                        return false;
                    } else {
                        label50: {
                            if (this.serverProperties != null) {
                                if (this.serverProperties.equals(that.serverProperties)) {
                                    break label50;
                                }
                            } else if (that.serverProperties == null) {
                                break label50;
                            }

                            return false;
                        }

                        if (this.mechanisms != null) {
                            if (!this.mechanisms.equals(that.mechanisms)) {
                                return false;
                            }
                        } else if (that.mechanisms != null) {
                            return false;
                        }

                        if (this.locales != null) {
                            if (!this.locales.equals(that.locales)) {
                                return false;
                            }
                        } else if (that.locales != null) {
                            return false;
                        }

                        return true;
                    }
                } else {
                    return false;
                }
            }

            public int hashCode() {
                int result = 0;
                result = 31 * result + this.versionMajor;
                result = 31 * result + this.versionMinor;
                result = 31 * result + (this.serverProperties != null ? this.serverProperties.hashCode() : 0);
                result = 31 * result + (this.mechanisms != null ? this.mechanisms.hashCode() : 0);
                result = 31 * result + (this.locales != null ? this.locales.hashCode() : 0);
                return result;
            }

            public void appendArgumentDebugStringTo(StringBuilder acc) {
                acc.append("(version-major=").append(this.versionMajor).append(", version-minor=").append(this.versionMinor).append(", server-properties=").append(this.serverProperties).append(", mechanisms=").append(this.mechanisms).append(", locales=").append(this.locales).append(")");
            }

            public void writeArgumentsTo(MethodArgumentWriter writer) throws IOException {
                writer.writeOctet(this.versionMajor);
                writer.writeOctet(this.versionMinor);
                writer.writeTable(this.serverProperties);
                writer.writeLongstr(this.mechanisms);
                writer.writeLongstr(this.locales);
            }
        }
    }
}

