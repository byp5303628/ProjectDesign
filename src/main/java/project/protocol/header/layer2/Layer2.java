package project.protocol.header.layer2;

import project.protocol.header.layer3.LAYER_3_PROTOCOL;

public abstract class Layer2 {
   public abstract LAYER_3_PROTOCOL getNextProtocol();
}
