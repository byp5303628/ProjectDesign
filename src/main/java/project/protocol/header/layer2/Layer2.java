package project.protocol.header.layer2;

import project.protocol.header.layer3.Layer3Protocol;

public abstract class Layer2 {
   public abstract Layer3Protocol getNextProtocol();
}
