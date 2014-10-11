package project.protocol.datagram.layer2.frametype;

import project.exceptions.InvalidFrameType;
import project.protocol.datagram.layer2.FrameType;

public class Ipv4FrameType extends FrameType {
   public Ipv4FrameType() throws InvalidFrameType {
      this.setFrameType("0800");
   }
}
