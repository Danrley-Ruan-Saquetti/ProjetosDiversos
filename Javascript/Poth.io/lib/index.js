// src/contracts/engine/event.ts
var EventPriority = /* @__PURE__ */ ((EventPriority2) => {
  EventPriority2[EventPriority2["HIGH"] = 0] = "HIGH";
  EventPriority2[EventPriority2["NORMAL"] = 1] = "NORMAL";
  EventPriority2[EventPriority2["LOW"] = 2] = "LOW";
  return EventPriority2;
})(EventPriority || {});

// src/contracts/engine/input.ts
var Keys = /* @__PURE__ */ ((Keys2) => {
  Keys2["KeyA"] = "KeyA";
  Keys2["KeyB"] = "KeyB";
  Keys2["KeyC"] = "KeyC";
  Keys2["KeyD"] = "KeyD";
  Keys2["KeyE"] = "KeyE";
  Keys2["KeyF"] = "KeyF";
  Keys2["KeyG"] = "KeyG";
  Keys2["KeyH"] = "KeyH";
  Keys2["KeyI"] = "KeyI";
  Keys2["KeyJ"] = "KeyJ";
  Keys2["KeyK"] = "KeyK";
  Keys2["KeyL"] = "KeyL";
  Keys2["KeyM"] = "KeyM";
  Keys2["KeyN"] = "KeyN";
  Keys2["KeyO"] = "KeyO";
  Keys2["KeyP"] = "KeyP";
  Keys2["KeyQ"] = "KeyQ";
  Keys2["KeyR"] = "KeyR";
  Keys2["KeyS"] = "KeyS";
  Keys2["KeyT"] = "KeyT";
  Keys2["KeyU"] = "KeyU";
  Keys2["KeyV"] = "KeyV";
  Keys2["KeyW"] = "KeyW";
  Keys2["KeyX"] = "KeyX";
  Keys2["KeyY"] = "KeyY";
  Keys2["KeyZ"] = "KeyZ";
  Keys2["Digit0"] = "Digit0";
  Keys2["Digit1"] = "Digit1";
  Keys2["Digit2"] = "Digit2";
  Keys2["Digit3"] = "Digit3";
  Keys2["Digit4"] = "Digit4";
  Keys2["Digit5"] = "Digit5";
  Keys2["Digit6"] = "Digit6";
  Keys2["Digit7"] = "Digit7";
  Keys2["Digit8"] = "Digit8";
  Keys2["Digit9"] = "Digit9";
  Keys2["Minus"] = "Minus";
  Keys2["Equal"] = "Equal";
  Keys2["BracketLeft"] = "BracketLeft";
  Keys2["BracketRight"] = "BracketRight";
  Keys2["Backslash"] = "Backslash";
  Keys2["Semicolon"] = "Semicolon";
  Keys2["Quote"] = "Quote";
  Keys2["Backquote"] = "Backquote";
  Keys2["Comma"] = "Comma";
  Keys2["Period"] = "Period";
  Keys2["Slash"] = "Slash";
  Keys2["Escape"] = "Escape";
  Keys2["Enter"] = "Enter";
  Keys2["Tab"] = "Tab";
  Keys2["Space"] = "Space";
  Keys2["Backspace"] = "Backspace";
  Keys2["ShiftLeft"] = "ShiftLeft";
  Keys2["ShiftRight"] = "ShiftRight";
  Keys2["ControlLeft"] = "ControlLeft";
  Keys2["ControlRight"] = "ControlRight";
  Keys2["AltLeft"] = "AltLeft";
  Keys2["AltRight"] = "AltRight";
  Keys2["MetaLeft"] = "MetaLeft";
  Keys2["MetaRight"] = "MetaRight";
  Keys2["CapsLock"] = "CapsLock";
  Keys2["NumLock"] = "NumLock";
  Keys2["ScrollLock"] = "ScrollLock";
  Keys2["ArrowUp"] = "ArrowUp";
  Keys2["ArrowDown"] = "ArrowDown";
  Keys2["ArrowLeft"] = "ArrowLeft";
  Keys2["ArrowRight"] = "ArrowRight";
  Keys2["Home"] = "Home";
  Keys2["End"] = "End";
  Keys2["PageUp"] = "PageUp";
  Keys2["PageDown"] = "PageDown";
  Keys2["Insert"] = "Insert";
  Keys2["Delete"] = "Delete";
  Keys2["F1"] = "F1";
  Keys2["F2"] = "F2";
  Keys2["F3"] = "F3";
  Keys2["F4"] = "F4";
  Keys2["F5"] = "F5";
  Keys2["F6"] = "F6";
  Keys2["F7"] = "F7";
  Keys2["F8"] = "F8";
  Keys2["F9"] = "F9";
  Keys2["F10"] = "F10";
  Keys2["F11"] = "F11";
  Keys2["F12"] = "F12";
  Keys2["F13"] = "F13";
  Keys2["F14"] = "F14";
  Keys2["F15"] = "F15";
  Keys2["F16"] = "F16";
  Keys2["F17"] = "F17";
  Keys2["F18"] = "F18";
  Keys2["F19"] = "F19";
  Keys2["F20"] = "F20";
  Keys2["F21"] = "F21";
  Keys2["F22"] = "F22";
  Keys2["F23"] = "F23";
  Keys2["F24"] = "F24";
  Keys2["Numpad0"] = "Numpad0";
  Keys2["Numpad1"] = "Numpad1";
  Keys2["Numpad2"] = "Numpad2";
  Keys2["Numpad3"] = "Numpad3";
  Keys2["Numpad4"] = "Numpad4";
  Keys2["Numpad5"] = "Numpad5";
  Keys2["Numpad6"] = "Numpad6";
  Keys2["Numpad7"] = "Numpad7";
  Keys2["Numpad8"] = "Numpad8";
  Keys2["Numpad9"] = "Numpad9";
  Keys2["NumpadAdd"] = "NumpadAdd";
  Keys2["NumpadSubtract"] = "NumpadSubtract";
  Keys2["NumpadMultiply"] = "NumpadMultiply";
  Keys2["NumpadDivide"] = "NumpadDivide";
  Keys2["NumpadDecimal"] = "NumpadDecimal";
  Keys2["NumpadEnter"] = "NumpadEnter";
  Keys2["MediaPlayPause"] = "MediaPlayPause";
  Keys2["MediaStop"] = "MediaStop";
  Keys2["MediaTrackNext"] = "MediaTrackNext";
  Keys2["MediaTrackPrevious"] = "MediaTrackPrevious";
  Keys2["VolumeMute"] = "VolumeMute";
  Keys2["VolumeUp"] = "VolumeUp";
  Keys2["VolumeDown"] = "VolumeDown";
  Keys2["ContextMenu"] = "ContextMenu";
  Keys2["PrintScreen"] = "PrintScreen";
  Keys2["Pause"] = "Pause";
  return Keys2;
})(Keys || {});

// src/ecs/archetype.ts
var ArchetypeProfile = /* @__PURE__ */ ((ArchetypeProfile2) => {
  ArchetypeProfile2[ArchetypeProfile2["UNIQUE"] = 1] = "UNIQUE";
  ArchetypeProfile2[ArchetypeProfile2["SMALL"] = 8] = "SMALL";
  ArchetypeProfile2[ArchetypeProfile2["COMMON"] = 64] = "COMMON";
  ArchetypeProfile2[ArchetypeProfile2["MASSIVE"] = 256] = "MASSIVE";
  return ArchetypeProfile2;
})(ArchetypeProfile || {});

// src/ecs/component.ts
var ComponentFieldType = /* @__PURE__ */ ((ComponentFieldType2) => {
  ComponentFieldType2[ComponentFieldType2["Int8"] = 0] = "Int8";
  ComponentFieldType2[ComponentFieldType2["Uint8"] = 1] = "Uint8";
  ComponentFieldType2[ComponentFieldType2["Uint8Clamped"] = 2] = "Uint8Clamped";
  ComponentFieldType2[ComponentFieldType2["Int16"] = 3] = "Int16";
  ComponentFieldType2[ComponentFieldType2["Uint16"] = 4] = "Uint16";
  ComponentFieldType2[ComponentFieldType2["Int32"] = 5] = "Int32";
  ComponentFieldType2[ComponentFieldType2["Uint32"] = 6] = "Uint32";
  ComponentFieldType2[ComponentFieldType2["Float16"] = 7] = "Float16";
  ComponentFieldType2[ComponentFieldType2["Float32"] = 8] = "Float32";
  ComponentFieldType2[ComponentFieldType2["Float64"] = 9] = "Float64";
  ComponentFieldType2[ComponentFieldType2["BigInt64"] = 10] = "BigInt64";
  ComponentFieldType2[ComponentFieldType2["BigUint64"] = 11] = "BigUint64";
  return ComponentFieldType2;
})(ComponentFieldType || {});

// src/runtime/buffer/buffer-consumer.ts
var BufferConsumer = class {
  constructor(buffer, dispatcher) {
    this.buffer = buffer;
    this.dispatcher = dispatcher;
  }
  send(item) {
    this.buffer.send(item);
  }
  execute() {
    const items = this.buffer.flush();
    if (!this.dispatcher) {
      return;
    }
    let i = 0, length = items.length;
    while (i < length) {
      this.dispatcher.dispatch(items[i]);
      i++;
    }
  }
};

// src/runtime/buffer/double-buffering.ts
var DoubleBuffering = class {
  constructor() {
    this.buffer = [];
    this.swap = [];
  }
  send(item) {
    this.buffer.push(item);
  }
  flush() {
    const temp = this.buffer;
    this.buffer = this.swap;
    this.swap = temp;
    this.buffer.length = 0;
    return this.swap;
  }
  size() {
    return this.buffer.length;
  }
};

// src/runtime/buffer/double-buffering-consumer.ts
var DoubleBufferingConsumer = class extends BufferConsumer {
  constructor(dispatcher) {
    super(new DoubleBuffering(), dispatcher);
  }
};

// src/engine/command/command-scheduler.ts
var CommandScheduler = class {
  constructor() {
    this.domains = [];
  }
  register(domain) {
    this.domains.push(domain);
  }
  flush() {
    let i = 0, length = this.domains.length;
    while (i < length) {
      this.domains[i].flush();
      i++;
    }
  }
};

// src/engine/events/event-bus-priority.ts
var EventBusPriority = class {
  constructor() {
    this.listeners = /* @__PURE__ */ Object.create(null);
  }
  on(event, listener, priority = 1 /* NORMAL */) {
    let buckets = this.listeners[event];
    if (!buckets) {
      buckets = [[], [], []];
      this.listeners[event] = buckets;
    }
    buckets[priority].push(listener);
  }
  emit(event, data) {
    const buckets = this.listeners[event];
    if (!buckets) {
      return;
    }
    let i = 0, lengthBuckets = buckets.length;
    while (i < lengthBuckets) {
      const bucket = buckets[i];
      let j = 0, lengthBucket = bucket.length;
      while (j < lengthBucket) {
        bucket[j](data);
        j++;
      }
      i++;
    }
  }
  off(event, listener) {
    const buckets = this.listeners[event];
    if (!buckets) {
      return;
    }
    let i = 0, lengthBuckets = buckets.length;
    while (i < lengthBuckets) {
      const bucket = buckets[i];
      let j = 0, lengthBucket = bucket.length;
      while (j < lengthBucket) {
        if (bucket[j] === listener) {
          bucket[j] = bucket[bucket.length - 1];
          bucket.pop();
          return;
        }
        j++;
      }
      i++;
    }
  }
  clear(event) {
    if (event) {
      delete this.listeners[event];
    } else {
      this.listeners = /* @__PURE__ */ Object.create(null);
    }
  }
};

// src/engine/events/event-dispatcher.ts
var EventDispatcher = class {
  constructor(bus) {
    this.bus = bus;
  }
  on(event, listener, priority = 1 /* NORMAL */) {
    this.bus.on(event, listener, priority);
  }
  off(event, listener) {
    this.bus.off(event, listener);
  }
  clear(event) {
    this.bus.clear(event);
  }
  dispatch(event) {
    this.bus.emit(event[0], event[1]);
  }
};

// src/engine/mutable-system-initialize-context.ts
var MutableSystemInitializeContext = class {
};

// src/engine/system/system-scheduler.ts
var SystemScheduler = class {
  constructor(context) {
    this.context = context;
    this.systems = [];
    this.startSystems = [];
    this.stopSystems = [];
    this.updateBeforeSystems = [];
    this.updateSystems = [];
    this.updateAfterSystems = [];
    this.isStarted = false;
  }
  register(system) {
    system.initialize?.(this.context);
    this.systems.push(system);
    if (system.start) this.startSystems.push(system);
    if (system.stop) this.stopSystems.push(system);
    if (system.updateBefore) this.updateBeforeSystems.push(system);
    if (system.update) this.updateSystems.push(system);
    if (system.updateAfter) this.updateAfterSystems.push(system);
    if (this.isStarted && system.start) {
      system.start();
    }
  }
  start() {
    this.isStarted = true;
    let i = 0, length = this.startSystems.length;
    while (i < length) {
      this.startSystems[i].start();
      i++;
    }
  }
  stop() {
    this.isStarted = false;
    let i = 0, length = this.stopSystems.length;
    while (i < length) {
      this.stopSystems[i].stop();
      i++;
    }
  }
  tick(context) {
    this.tickBefore(context);
    this.tickUpdate(context);
    this.tickAfter(context);
  }
  tickBefore(context) {
    let i = 0, length = this.updateBeforeSystems.length;
    while (i < length) {
      this.updateBeforeSystems[i].updateBefore(context);
      i++;
    }
  }
  tickUpdate(context) {
    let i = 0, length = this.updateSystems.length;
    while (i < length) {
      this.updateSystems[i].update(context);
      i++;
    }
  }
  tickAfter(context) {
    let i = 0, length = this.updateAfterSystems.length;
    while (i < length) {
      this.updateAfterSystems[i].updateAfter(context);
      i++;
    }
  }
};

// src/engine/engine.ts
var Engine = class {
  constructor() {
    this.commandScheduler = new CommandScheduler();
    this.eventBus = new EventBusPriority();
    this.eventDispatcher = new EventDispatcher(this.eventBus);
    this.eventConsumer = new DoubleBufferingConsumer(this.eventDispatcher);
    this.systemInitializeContext = new MutableSystemInitializeContext();
    this._isRunning = false;
    this.isInitialized = false;
    this.systemScheduler = new SystemScheduler(this.systemInitializeContext);
    this.systemInitializeContext.events = {
      on: this.eventDispatcher.on.bind(this.eventDispatcher),
      send: (event, data) => this.eventConsumer.send([event, data]),
      off: this.eventDispatcher.off.bind(this.eventDispatcher),
      clear: this.eventDispatcher.clear.bind(this.eventDispatcher)
    };
    this.systemInitializeContext.commands = {
      register: this.commandScheduler.register.bind(this.commandScheduler)
    };
  }
  get systemContext() {
    return this.systemInitializeContext;
  }
  initialize(context) {
    if (this.isInitialized) {
      throw new Error("It is not possible to initialize an engine that has already been initialized");
    }
    this.systemInitializeContext.world = context.world;
    this.systemInitializeContext.scheduler = context.scheduler;
    this.isInitialized = true;
  }
  start() {
    if (this._isRunning) {
      throw new Error("Engine already started");
    }
    this._isRunning = true;
    this.systemScheduler.start();
    this.commandScheduler.flush();
  }
  stop() {
    if (!this._isRunning) {
      throw new Error("Engine already stopped");
    }
    this._isRunning = false;
    this.systemScheduler.stop();
  }
  tick(context) {
    if (!this._isRunning) {
      return;
    }
    this.systemScheduler.tick(context);
    this.eventConsumer.execute();
    this.commandScheduler.flush();
  }
  registerSystem(system) {
    this.systemScheduler.register(system);
  }
  registerCommandDomain(domain) {
    this.commandScheduler.register(domain);
  }
  isRunning() {
    return this._isRunning;
  }
};

// src/runtime/commands/command-domain.ts
var CommandDomain = class {
  constructor(maxPriority = 8) {
    this.buffers = [];
    this.activeBuffer = 0;
    this.handlers = /* @__PURE__ */ new Map();
    this.priorities = /* @__PURE__ */ new Map();
    for (let b = 0; b < 2; b++) {
      this.buffers[b] = [];
      for (let p = 0; p < maxPriority; p++) {
        this.buffers[b][p] = [];
      }
    }
  }
  get writeBuffer() {
    return this.buffers[this.activeBuffer];
  }
  get readBuffer() {
    return this.buffers[this.activeBuffer ^ 1];
  }
  register(command, handler, priority = 0) {
    if (this.handlers.has(command)) {
      throw new Error(`Event "${command}" already registered for this command domain`);
    }
    this.handlers.set(command, handler);
    this.priorities.set(command, priority);
  }
  send(command, data) {
    const priority = this.priorities.get(command);
    this.writeBuffer[priority].push([command, data]);
  }
  flush() {
    this.activeBuffer ^= 1;
    const buckets = this.readBuffer;
    let p = 0, bucketLength = buckets.length;
    while (p < bucketLength) {
      const queue = buckets[p];
      let i = 0, queueLength = queue.length;
      while (i < queueLength) {
        const command = queue[i];
        this.handlers.get(command[0])(command[1]);
        i++;
      }
      queue.length = 0;
      p++;
    }
  }
};

// src/runtime/world/archetype/archetype.ts
var Archetype = class {
  constructor(signature, registry) {
    this.signature = signature;
    this.registry = registry;
    this._entities = [];
    this.components = [];
    this.componentIds = [];
    this.componentIndex = /* @__PURE__ */ new Map();
    this.initialized = false;
  }
  get entities() {
    return this._entities;
  }
  get lastEntity() {
    return this._entities[this._entities.length - 1];
  }
  get size() {
    return this._entities.length;
  }
  initialize(initialCapacity) {
    if (this.initialized) {
      return;
    }
    const ids = this.registry.idsFromSignature(this.signature);
    let i = 0, length = ids.length;
    while (i < length) {
      this.componentIds.push(ids[i]);
      this.components.push(this.registry.createComponent(ids[i], initialCapacity));
      this.componentIndex.set(ids[i], this.components.length - 1);
      i++;
    }
    this.initialized = true;
  }
  addEntity(entityId, initialData) {
    this._entities.push(entityId);
    let i = 0, length = this.components.length;
    if (initialData) {
      while (i < length) {
        this.components[i].push(initialData[this.componentIds[i]]);
        i++;
      }
    } else {
      while (i < length) {
        this.components[i].push();
        i++;
      }
    }
  }
  addEntityFrom(entityId, entityIndex, from, initialData) {
    this._entities.push(entityId);
    let i = 0, length = this.components.length;
    while (i < length) {
      const componentId = this.componentIds[i];
      const fromIndex = from.componentIndex.get(componentId);
      if (fromIndex !== void 0) {
        this.components[i].copyFrom(from.components[fromIndex], entityIndex);
      } else {
        const initial = initialData ? initialData[componentId] : void 0;
        this.components[i].push(initial);
      }
      i++;
    }
  }
  removeEntity(index) {
    const lastIndex = this._entities.length - 1;
    const lastEntity = this._entities[lastIndex];
    this._entities[index] = lastEntity;
    this._entities.pop();
    let i = 0, length = this.components.length;
    while (i < length) {
      this.components[i].swap(index, lastIndex);
      this.components[i].pop();
      i++;
    }
  }
  component(component) {
    return this.components[this.componentIndex.get(component.id)];
  }
};

// src/runtime/world/archetype/components/component-data.ts
var FieldArrayConstructor = {
  [0 /* Int8 */]: Int8Array,
  [1 /* Uint8 */]: Uint8Array,
  [2 /* Uint8Clamped */]: Uint8ClampedArray,
  [3 /* Int16 */]: Int16Array,
  [4 /* Uint16 */]: Uint16Array,
  [5 /* Int32 */]: Int32Array,
  [6 /* Uint32 */]: Uint32Array,
  [7 /* Float16 */]: Float16Array,
  [8 /* Float32 */]: Float32Array,
  [9 /* Float64 */]: Float64Array,
  [10 /* BigInt64 */]: BigInt64Array,
  [11 /* BigUint64 */]: BigUint64Array
};
var ComponentData = class {
  constructor(schema, initialCapacity = 64) {
    this.schema = schema;
    this._size = 0;
    this.capacity = 0;
    const fields = {};
    for (const field in schema) {
      const type = schema[field];
      const ArrayConstructor = FieldArrayConstructor[type];
      fields[field] = new ArrayConstructor(initialCapacity);
    }
    this.capacity = initialCapacity;
    this.fields = fields;
  }
  get size() {
    return this._size;
  }
  get isFull() {
    return this._size >= this.capacity;
  }
  get data() {
    return this.fields;
  }
  push(initialValues) {
    if (this.isFull) {
      this.grow();
    }
    for (const field in this.fields) {
      const value = initialValues && initialValues[field] !== void 0 ? initialValues[field] : 0;
      this.fields[field][this._size] = value;
    }
    this._size++;
  }
  pop() {
    if (this._size > 0) {
      this._size--;
    }
  }
  swap(indexA, indexB) {
    for (const field in this.fields) {
      const items = this.fields[field];
      const temp = items[indexA];
      items[indexA] = items[indexB];
      items[indexB] = temp;
    }
  }
  copyFrom(other, index) {
    if (this.isFull) {
      this.grow();
    }
    for (const field in this.fields) {
      this.fields[field][this._size] = other.field(field)[index];
    }
    this._size++;
  }
  field(field) {
    return this.fields[field];
  }
  grow() {
    const newCapacity = this.capacity * 3;
    for (const field in this.fields) {
      const type = this.schema[field];
      const oldArray = this.fields[field];
      const ArrayConstructor = FieldArrayConstructor[type];
      const newArray = new ArrayConstructor(newCapacity);
      newArray.set(oldArray);
      this.fields[field] = newArray;
    }
    this.capacity = newCapacity;
  }
};

// src/runtime/world/archetype/components/component-registry.ts
var ComponentRegistry = class {
  constructor() {
    this.schemas = /* @__PURE__ */ new Map();
    this.signatureCache = /* @__PURE__ */ new Map();
    this.nextId = 1n;
  }
  register(name, schema) {
    const id = this.nextId++;
    this.schemas.set(id, schema);
    return { id, name, schema };
  }
  createComponent(id, initialCapacity) {
    const schema = this.schemas.get(id);
    if (!schema) {
      throw new Error(`Component schema not found for id: ${id}`);
    }
    return new ComponentData(schema, initialCapacity);
  }
  idsFromSignature(sig) {
    const key = sig.toString();
    let ids = this.signatureCache.get(key);
    if (ids) {
      return ids;
    }
    ids = [];
    let bit = 0n;
    while (sig > 0n) {
      if ((sig & 1n) !== 0n) {
        ids.push(bit);
      }
      sig >>= 1n;
      bit++;
    }
    this.signatureCache.set(key, ids);
    return ids;
  }
};
var GlobalComponentRegistry = new ComponentRegistry();
function createComponent(name, schema) {
  return GlobalComponentRegistry.register(name, schema);
}

// src/runtime/world/archetype/create-signature.ts
function createSignature(components) {
  let signature = 0n;
  let i = 0, length = components.length;
  while (i < length) {
    signature |= 1n << components[i].id;
    i++;
  }
  return signature;
}

// src/runtime/world/archetype/components/merge-component-data.ts
function mergeComponentData(defaults, overrides) {
  if (!defaults && !overrides) {
    return void 0;
  }
  if (!defaults) {
    return overrides;
  }
  if (!overrides) {
    return defaults;
  }
  const result = {};
  for (const key in defaults) {
    result[key] = defaults[key];
  }
  for (const key in overrides) {
    result[key] = overrides[key];
  }
  return result;
}

// src/runtime/world/entity/prefab-entity.ts
var PrefabEntity = class {
  constructor(world, components = [], properties = {}) {
    this.world = world;
    this.components = components;
    this.properties = properties;
  }
  spawn(overrides) {
    const components = [];
    let i = 0, length = this.components.length;
    while (i < length) {
      const component = this.components[i];
      const data = overrides ? mergeComponentData(component.data, overrides[component.component.name]) : component.data;
      components.push({ component: component.component, data });
      i++;
    }
    return this.world.spawn({
      components,
      profile: this.properties.profile
    });
  }
  getQuery() {
    const components = [];
    let i = 0, length = this.components.length;
    while (i < length) {
      components.push(this.components[i].component);
      i++;
    }
    return this.world.getQuery(components);
  }
};

// src/runtime/world/entity/prefab-definition.ts
var PrefabDefinition = class {
  constructor(components = [], properties = {}) {
    this.components = components;
    this.properties = properties;
  }
  instantiate(world) {
    return new PrefabEntity(world, this.components, this.properties);
  }
};

// src/runtime/world/entity/entity-builder.ts
var EntityBuilder = class {
  constructor(properties = {}) {
    this.properties = properties;
    this.defaults = {};
    this.components = [];
  }
  with(component, defaultValue) {
    this.defaults[component.name] = defaultValue ?? {};
    this.components.push({ component, data: defaultValue });
    return this;
  }
  build() {
    return new PrefabDefinition(this.components, this.properties);
  }
};

// src/runtime/world/entity/entity-pool.ts
var EntityPool = class {
  constructor() {
    this.nextId = 1;
    this.freeIds = [];
  }
  create() {
    return this.freeIds.length ? this.freeIds.pop() : this.nextId++;
  }
  destroy(entityId) {
    this.freeIds.push(entityId);
  }
};

// src/runtime/world/query/query.ts
var Query = class {
  constructor(world, components = []) {
    this.world = world;
    this.matched = [];
    this.mask = createSignature(components);
  }
  onArchetypeAdded(archetype) {
    if ((archetype.signature & this.mask) !== this.mask) {
      return;
    }
    this.matched.push(archetype);
  }
  build() {
    this.matched.length = 0;
    for (const archetype of this.world.getArchetypes()) {
      if ((archetype.signature & this.mask) !== this.mask) {
        continue;
      }
      this.matched.push(archetype);
    }
  }
  view() {
    return this.matched;
  }
  find(max) {
    if (max) {
      return this.findLimited(max);
    }
    return this.findAll();
  }
  findFirstLocation() {
    const entityId = this.findFirst();
    if (!entityId) {
      return void 0;
    }
    return this.world.getEntityLocation(entityId);
  }
  findFirst() {
    let i = 0, length = this.matched.length;
    while (i < length) {
      if (this.matched[i].size) {
        return this.matched[i].entities[0];
      }
      i++;
    }
    return void 0;
  }
  count() {
    let count = 0;
    let i = 0, length = this.matched.length;
    while (i < length) {
      count += this.matched[i].size;
      i++;
    }
    return count;
  }
  isEmpty() {
    let i = 0, length = this.matched.length;
    while (i < length) {
      if (this.matched[i].size) {
        return false;
      }
      i++;
    }
    return true;
  }
  has(entityId) {
    let i = 0, length = this.matched.length;
    while (i < length) {
      const entities = this.matched[i].entities;
      let j = 0, size = this.matched[i].size;
      while (j < size) {
        if (entities[j] === entityId) {
          return true;
        }
        j++;
      }
      i++;
    }
    return false;
  }
  findAll() {
    const entitiesId = [];
    let i = 0, length = this.matched.length;
    while (i < length) {
      const entities = this.matched[i].entities;
      let j = 0, size = this.matched[i].size;
      while (j < size) {
        entitiesId.push(entities[j]);
        j++;
      }
      i++;
    }
    return entitiesId;
  }
  findLimited(max) {
    const entitiesId = [];
    let i = 0, length = this.matched.length;
    while (i < length) {
      const entities = this.matched[i].entities;
      let j = 0, size = this.matched[i].size;
      while (j < size) {
        entitiesId.push(entities[j]);
        if (entitiesId.length >= max) {
          return entitiesId;
        }
        j++;
      }
      i++;
    }
    return entitiesId;
  }
};

// src/runtime/world/query/query-manager.ts
var QueryManager = class {
  constructor(world) {
    this.world = world;
    this.queries = /* @__PURE__ */ new Map();
  }
  getOrCreateQuery(components) {
    const signature = createSignature(components);
    const key = signature.toString();
    let query = this.queries.get(key);
    if (query) {
      return query;
    }
    query = new Query(this.world, components);
    query.build();
    this.queries.set(key, query);
    return query;
  }
  onArchetypeCreated(archetype) {
    for (const query of this.queries.values()) {
      query.onArchetypeAdded(archetype);
    }
  }
};

// src/runtime/world/game-world.ts
var GameWorldCommandPhase = /* @__PURE__ */ ((GameWorldCommandPhase2) => {
  GameWorldCommandPhase2[GameWorldCommandPhase2["CREATE_ENTITY"] = 0] = "CREATE_ENTITY";
  GameWorldCommandPhase2[GameWorldCommandPhase2["CREATE_ENTITY_WITH_COMPONENTS"] = 1] = "CREATE_ENTITY_WITH_COMPONENTS";
  GameWorldCommandPhase2[GameWorldCommandPhase2["DESTROY_ENTITY"] = 2] = "DESTROY_ENTITY";
  GameWorldCommandPhase2[GameWorldCommandPhase2["ADD_COMPONENT"] = 3] = "ADD_COMPONENT";
  return GameWorldCommandPhase2;
})(GameWorldCommandPhase || {});
var GameWorld = class {
  constructor() {
    this.commandDomain = new CommandDomain(Object.keys(GameWorldCommandPhase).length);
    this.archetypes = /* @__PURE__ */ new Map();
    this.entityLocation = /* @__PURE__ */ new Map();
    this.entityPool = new EntityPool();
    this.queryManager = new QueryManager(this);
    this.commandDomain.register(
      "entity:create" /* CREATE_ENTITY */,
      this.performCreateEntity.bind(this),
      0 /* CREATE_ENTITY */
    );
    this.commandDomain.register(
      "entity:create-with-components" /* CREATE_ENTITY_WITH_COMPONENTS */,
      this.performCreateEntityWithComponents.bind(this),
      1 /* CREATE_ENTITY_WITH_COMPONENTS */
    );
    this.commandDomain.register(
      "entity:destroy" /* DESTROY_ENTITY */,
      this.performDestroyEntity.bind(this),
      2 /* DESTROY_ENTITY */
    );
    this.commandDomain.register(
      "component:add" /* ADD_COMPONENT */,
      this.performAddComponent.bind(this),
      3 /* ADD_COMPONENT */
    );
  }
  flush() {
    this.commandDomain.flush();
  }
  spawn({ components, profile }) {
    const id = this.entityPool.create();
    if (!components || !components.length) {
      this.commandDomain.send("entity:create" /* CREATE_ENTITY */, { entityId: id, profile });
      return id;
    }
    this.commandDomain.send("entity:create-with-components" /* CREATE_ENTITY_WITH_COMPONENTS */, {
      entityId: id,
      profile,
      components: components.map((component) => ({
        id: component.component.id,
        data: component.data
      }))
    });
    return id;
  }
  destroy(entityId) {
    this.commandDomain.send("entity:destroy" /* DESTROY_ENTITY */, entityId);
  }
  addComponent(entityId, component, initialData) {
    this.commandDomain.send("component:add" /* ADD_COMPONENT */, { entityId, componentId: component.id, data: initialData });
  }
  createPrefab(properties) {
    return new EntityBuilder(properties);
  }
  getQuery(components) {
    return this.queryManager.getOrCreateQuery(components);
  }
  findFirst(components) {
    return this.queryManager.getOrCreateQuery(components).findFirst();
  }
  findSingleton(components) {
    const entitiesId = this.queryManager.getOrCreateQuery(components).find(2);
    return entitiesId.length == 1 ? entitiesId[0] : void 0;
  }
  expectSingleton(components) {
    const entitiesId = this.queryManager.getOrCreateQuery(components).find(2);
    if (!entitiesId.length) {
      throw new Error(`Expect Singleton failed: no entity with components [${components.map(({ name }) => name).join(", ")}]`);
    }
    if (entitiesId.length > 1) {
      throw new Error(`Expect Singleton failed: more than one entity found with components [${components.map(({ name }) => name).join(", ")}]`);
    }
    return entitiesId[0];
  }
  find(components) {
    return this.queryManager.getOrCreateQuery(components).find();
  }
  count(components) {
    return this.queryManager.getOrCreateQuery(components).count();
  }
  isEmpty(components) {
    return this.queryManager.getOrCreateQuery(components).isEmpty();
  }
  exists(components) {
    return !this.queryManager.getOrCreateQuery(components).isEmpty();
  }
  hasEntity(entityId) {
    return !!this.entityLocation.get(entityId);
  }
  getEntityLocation(entityId) {
    return this.entityLocation.get(entityId);
  }
  expectEntity(entityId) {
    const entity = this.entityLocation.get(entityId);
    if (!entity) {
      throw new Error(`Expect Entity failed: entity "${entityId}" found`);
    }
    return entity;
  }
  getArchetypes() {
    return this.archetypes.values();
  }
  performCreateEntity({ entityId, profile }) {
    const emptyArchetype = this.getOrCreateArchetype(0n, profile);
    emptyArchetype.addEntity(entityId);
    this.entityLocation.set(entityId, {
      archetype: emptyArchetype,
      index: emptyArchetype.size - 1
    });
  }
  performCreateEntityWithComponents({ entityId, components, profile }) {
    const signature = createSignature(components);
    let initialData = {};
    let i = 0, length = components.length;
    while (i < length) {
      if (components[i].data !== void 0) {
        initialData[components[i].id] = components[i].data;
      }
      i++;
    }
    const emptyArchetype = this.getOrCreateArchetype(signature, profile);
    emptyArchetype.addEntity(entityId, initialData);
    this.entityLocation.set(entityId, {
      archetype: emptyArchetype,
      index: emptyArchetype.size - 1
    });
  }
  performDestroyEntity(entityId) {
    const location = this.entityLocation.get(entityId);
    if (!location) {
      return;
    }
    const { archetype, index } = location;
    const lastEntity = archetype.lastEntity;
    archetype.removeEntity(index);
    this.entityLocation.get(lastEntity).index = index;
    this.entityLocation.delete(entityId);
    this.entityPool.destroy(entityId);
  }
  performAddComponent({ entityId, componentId, data }) {
    const location = this.entityLocation.get(entityId);
    if (!location) {
      return;
    }
    const oldArchetype = location.archetype;
    const newSignature = oldArchetype.signature | 1n << componentId;
    if (newSignature === oldArchetype.signature) {
      return;
    }
    const newArch = this.getOrCreateArchetype(newSignature);
    const initialData = data !== void 0 ? { [componentId]: data } : void 0;
    this.moveEntity(entityId, location, oldArchetype, newArch, initialData);
  }
  moveEntity(entityId, location, from, to, initialData) {
    to.addEntityFrom(entityId, location.index, from, initialData);
    this.removeFromArchetype(location, from);
    this.entityLocation.set(entityId, { archetype: to, index: to.size - 1 });
  }
  removeFromArchetype(location, archetype) {
    const { index } = location;
    const lastEntity = archetype.lastEntity;
    archetype.removeEntity(index);
    this.entityLocation.get(lastEntity).index = index;
  }
  getOrCreateArchetype(signature, profile) {
    const key = signature.toString();
    let archetype = this.archetypes.get(key);
    if (!archetype) {
      archetype = new Archetype(signature, GlobalComponentRegistry);
      archetype.initialize(profile ?? 64 /* COMMON */);
      this.archetypes.set(key, archetype);
      this.queryManager.onArchetypeCreated(archetype);
    }
    return archetype;
  }
};

// src/game-runtime/mutable-system-update-context.ts
var MutableSystemUpdateContext = class {
};

// src/engine/input/input-state.ts
var InputState = class {
  constructor(config = {}) {
    this.keys = {
      held: /* @__PURE__ */ new Set(),
      down: /* @__PURE__ */ new Set(),
      up: /* @__PURE__ */ new Set()
    };
    this.mouseDelta = {
      x: 0,
      y: 0
    };
    this.mousePosition = {
      x: 0,
      y: 0
    };
    this.buttons = {
      held: /* @__PURE__ */ new Set(),
      down: /* @__PURE__ */ new Set(),
      up: /* @__PURE__ */ new Set()
    };
    this.keysToAdd = /* @__PURE__ */ new Set();
    this.keysToRemove = /* @__PURE__ */ new Set();
    this.buttonsToAdd = /* @__PURE__ */ new Set();
    this.buttonsToRemove = /* @__PURE__ */ new Set();
    this.bufferMouseDelta = { x: 0, y: 0 };
    this.bufferMousePosition = { x: 0, y: 0 };
    this.config = {
      mouseSensitivity: 1
    };
    if (config.mouseSensitivity !== void 0) {
      this.config.mouseSensitivity = config.mouseSensitivity;
    }
  }
  update() {
    this.keys.down.clear();
    this.keys.up.clear();
    this.buttons.down.clear();
    this.buttons.up.clear();
    for (const value of this.keysToRemove) {
      this.keys.held.delete(value);
      this.keys.up.add(value);
    }
    this.keysToRemove.clear();
    for (const value of this.keysToAdd) {
      this.keys.held.add(value);
      this.keys.down.add(value);
    }
    this.keysToAdd.clear();
    for (const value of this.buttonsToRemove) {
      this.buttons.held.delete(value);
      this.buttons.up.add(value);
    }
    this.buttonsToRemove.clear();
    for (const value of this.buttonsToAdd) {
      this.buttons.held.add(value);
      this.buttons.down.add(value);
    }
    this.buttonsToAdd.clear();
    this.mousePosition.x = this.bufferMousePosition.x;
    this.mousePosition.y = this.bufferMousePosition.y;
    this.mouseDelta.x = this.bufferMouseDelta.x * this.config.mouseSensitivity;
    this.mouseDelta.y = this.bufferMouseDelta.y * this.config.mouseSensitivity;
    this.bufferMouseDelta.x = 0;
    this.bufferMouseDelta.y = 0;
  }
  reset() {
    this.keys.down.clear();
    this.keys.held.clear();
    this.keys.up.clear();
    this.buttons.down.clear();
    this.buttons.held.clear();
    this.buttons.up.clear();
    this.keysToAdd.clear();
    this.keysToRemove.clear();
    this.buttonsToAdd.clear();
    this.buttonsToRemove.clear();
    this.bufferMouseDelta.x = 0;
    this.bufferMouseDelta.y = 0;
    this.bufferMousePosition.x = 0;
    this.bufferMousePosition.y = 0;
    this.mouseDelta.x = 0;
    this.mouseDelta.y = 0;
    this.mousePosition.x = 0;
    this.mousePosition.y = 0;
  }
  keyDown(key) {
    if (this.keys.held.has(key)) {
      return;
    }
    this.keysToAdd.add(key);
    this.keysToRemove.delete(key);
  }
  keyUp(key) {
    this.keysToRemove.add(key);
    this.keysToAdd.delete(key);
  }
  mouseDown(button) {
    if (this.buttons.held.has(button)) {
      return;
    }
    this.buttonsToAdd.add(button);
    this.buttonsToRemove.delete(button);
  }
  mouseUp(button) {
    this.buttonsToRemove.add(button);
    this.buttonsToAdd.delete(button);
  }
  mouseMove(deltaX, deltaY) {
    this.bufferMouseDelta.x += deltaX;
    this.bufferMouseDelta.y += deltaY;
  }
  setMousePosition(x, y) {
    this.bufferMousePosition.x = x;
    this.bufferMousePosition.y = y;
  }
  isKeyHeld(key) {
    return this.keys.held.has(key);
  }
  isKeyDown(key) {
    return this.keys.down.has(key);
  }
  isKeyUp(key) {
    return this.keys.up.has(key);
  }
  isMouseButtonHeld(button) {
    return this.buttons.held.has(button);
  }
  isMouseButtonDown(button) {
    return this.buttons.down.has(button);
  }
  isMouseButtonUp(button) {
    return this.buttons.up.has(button);
  }
  getMouseDeltaX() {
    return this.mouseDelta.x;
  }
  getMouseDeltaY() {
    return this.mouseDelta.y;
  }
  getMousePositionX() {
    return this.mousePosition.x;
  }
  getMousePositionY() {
    return this.mousePosition.y;
  }
  getMouseDelta() {
    return this.mouseDelta;
  }
  getMousePosition() {
    return this.mousePosition;
  }
};

// src/runtime/systems/system.ts
var System = class {
};

// src/game-runtime/runtime-systems/input.system.ts
var InputSystem = class extends System {
  constructor() {
    super(...arguments);
    this._state = new InputState({ mouseSensitivity: 2e-3 });
    this.onKeyDown = (e) => {
      if (e.repeat) {
        return;
      }
      this._state.keyDown(e.code);
    };
    this.onKeyUp = (e) => {
      this._state.keyUp(e.code);
    };
    this.onMouseDown = (e) => {
      this._state.mouseDown(e.button);
    };
    this.onMouseUp = (e) => {
      this._state.mouseUp(e.button);
    };
    this.onMouseMove = (e) => {
      this._state.setMousePosition(e.clientX, e.clientY);
      if (document.pointerLockElement === null) {
        return;
      }
      this._state.mouseMove(e.movementX, e.movementY);
    };
    this.onBlur = () => {
      this._state.reset();
    };
  }
  get state() {
    return this._state;
  }
  start() {
    this._state.reset();
    window.addEventListener("keydown", this.onKeyDown);
    window.addEventListener("keyup", this.onKeyUp);
    window.addEventListener("mousedown", this.onMouseDown);
    window.addEventListener("mouseup", this.onMouseUp);
    window.addEventListener("mousemove", this.onMouseMove);
    window.addEventListener("blur", this.onBlur);
  }
  stop() {
    this._state.reset();
    window.removeEventListener("keydown", this.onKeyDown);
    window.removeEventListener("keyup", this.onKeyUp);
    window.removeEventListener("mousedown", this.onMouseDown);
    window.removeEventListener("mouseup", this.onMouseUp);
    window.removeEventListener("mousemove", this.onMouseMove);
    window.removeEventListener("blur", this.onBlur);
  }
  update() {
    this._state.update();
  }
};

// src/structures/min-heap.ts
var MinHeap = class _MinHeap {
  constructor(compare = _MinHeap.defaultCompareHandler) {
    this.compare = compare;
    this.data = [];
  }
  get size() {
    return this.data.length;
  }
  static defaultCompareHandler(ref1, ref2) {
    return ref1 < ref2 ? -1 : ref1 > ref2 ? 1 : 0;
  }
  insert(value) {
    this.data.push(value);
    this.bubbleUp(this.data.length - 1);
  }
  removeMin() {
    if (this.data.length === 0) return void 0;
    if (this.data.length === 1) return this.data.pop();
    const root = this.data[0];
    this.data[0] = this.data.pop();
    this.bubbleDown(0);
    return root;
  }
  bubbleUp(index) {
    while (index > 0) {
      const parent = index - 1 >> 1;
      if (this.compare(this.data[index], this.data[parent]) >= 0) {
        break;
      }
      const temp = this.data[index];
      this.data[index] = this.data[parent];
      this.data[parent] = temp;
      index = parent;
    }
  }
  bubbleDown(index) {
    const length = this.data.length;
    while (true) {
      let smallest = index;
      const left = index * 2 + 1;
      const right = left + 1;
      if (left < length && this.compare(this.data[left], this.data[smallest]) < 0) {
        smallest = left;
      }
      if (right < length && this.compare(this.data[right], this.data[smallest]) < 0) {
        smallest = right;
      }
      if (smallest == index) {
        break;
      }
      const temp = this.data[index];
      this.data[index] = this.data[smallest];
      this.data[smallest] = temp;
      index = smallest;
    }
  }
  min() {
    return this.data[0];
  }
  isEmpty() {
    return this.data.length == 0;
  }
  clear() {
    this.data.length = 0;
  }
};

// src/runtime/time/schedule/timer-scheduler.ts
var TimerScheduler = class {
  constructor(windowSize = 1) {
    this.windowSize = windowSize;
    this.heap = new MinHeap(this.compareTasks.bind(this));
    this.active = [];
    this.seq = 1;
  }
  scheduleOnce(callback, delay, now) {
    const task = {
      executeAt: now + delay,
      seq: this.seq++,
      callback
    };
    this.heap.insert(task);
    return task;
  }
  scheduleRepeat(callback, interval, now) {
    const task = {
      executeAt: now + interval,
      interval,
      seq: this.seq++,
      callback
    };
    this.heap.insert(task);
    return task;
  }
  cancel(task) {
    task.cancelled = true;
  }
  update(now) {
    const windowLimit = now + this.windowSize;
    while (this.heap.size > 0) {
      const next = this.heap.min();
      if (next.executeAt > windowLimit) {
        break;
      }
      this.insertActive(this.heap.removeMin());
    }
    while (this.active.length > 0) {
      const task = this.active[0];
      if (task.executeAt > now) {
        break;
      }
      this.active.shift();
      if (task.cancelled) {
        continue;
      }
      task.callback();
      if (task.interval) {
        this.reschedule(task);
      }
    }
  }
  reschedule(task) {
    task.executeAt += task.interval;
    task.seq = this.seq++;
    this.heap.insert(task);
  }
  insertActive(task) {
    let low = 0;
    let high = this.active.length;
    while (low < high) {
      const mid = low + high >> 1;
      if (this.compareTasks(task, this.active[mid]) < 0) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    this.active.splice(low, 0, task);
  }
  compareTasks(taskA, taskB) {
    if (taskA.executeAt == taskB.executeAt) {
      return taskA.seq - taskB.seq;
    }
    return taskA.executeAt - taskB.executeAt;
  }
};

// src/game-runtime/runtime-systems/scheduler.system.ts
var SchedulerSystem = class extends System {
  constructor() {
    super(...arguments);
    this.scheduler = new TimerScheduler();
    this.elapsedTime = 0;
  }
  update(context) {
    this.elapsedTime = context.time.totalElapsedTimeMilliseconds;
    this.scheduler.update(context.time.totalElapsedTimeMilliseconds);
  }
  scheduleOnce(callback, delay) {
    return this.scheduler.scheduleOnce(callback, delay, this.elapsedTime);
  }
  scheduleRepeat(callback, interval) {
    return this.scheduler.scheduleRepeat(callback, interval, this.elapsedTime);
  }
  cancel(task) {
    return this.scheduler.cancel(task);
  }
};

// src/game-runtime/time/time-tracker.ts
var TimeTracker = class {
  constructor() {
    this.totalElapsedTime = 0;
    this.deltaTime = 0;
    this._time = {
      deltaTime: 0,
      deltaTimeMilliseconds: 0,
      totalElapsedTime: 0,
      totalElapsedTimeMilliseconds: 0
    };
  }
  get time() {
    return this._time;
  }
  reset() {
    this.deltaTime = 0;
    this.totalElapsedTime = 0;
    this._time.deltaTime = 0;
    this._time.deltaTimeMilliseconds = 0;
    this._time.totalElapsedTime = 0;
    this._time.totalElapsedTimeMilliseconds = 0;
  }
  advance(milliseconds) {
    this.deltaTime = milliseconds;
    this.totalElapsedTime += this.deltaTime;
    this.updateState();
  }
  updateState() {
    this._time.deltaTime = this.deltaTime / 1e3;
    this._time.deltaTimeMilliseconds = this.deltaTime;
    this._time.totalElapsedTime = this.totalElapsedTime / 1e3;
    this._time.totalElapsedTimeMilliseconds = this.totalElapsedTime;
  }
  getState() {
    return this._time;
  }
};

// src/game-runtime/game.ts
var Game = class {
  constructor() {
    this.engine = new Engine();
    this.world = new GameWorld();
    this.clock = new TimeTracker();
    this.systemContext = new MutableSystemUpdateContext();
    this.inputSystem = new InputSystem();
    this.schedulerSystem = new SchedulerSystem();
    this.lastTime = 0;
    this.update = (timestamp) => {
      this.updateEngine(timestamp);
      this.timeout = requestAnimationFrame(this.update);
    };
    this.systemContext.time = this.clock.time;
    this.systemContext.input = this.inputSystem.state;
    this.engine.initialize({
      world: this.world,
      scheduler: {
        scheduleOnce: this.schedulerSystem.scheduleOnce.bind(this.schedulerSystem),
        scheduleRepeat: this.schedulerSystem.scheduleRepeat.bind(this.schedulerSystem),
        cancel: this.schedulerSystem.cancel.bind(this.schedulerSystem)
      }
    });
  }
  start() {
    if (this.engine.isRunning()) {
      return;
    }
    this.initializeEngine();
    this.clock.reset();
    this.engine.start();
    this.initialize();
    this.update(0);
  }
  initializeEngine() {
    this.registerSystem(this.inputSystem);
    this.registerSystem(this.schedulerSystem);
    this.engine.registerCommandDomain(this.world);
  }
  initialize() {
  }
  stop() {
    if (!this.engine.isRunning()) {
      return;
    }
    this.engine.stop();
    cancelAnimationFrame(this.timeout);
  }
  updateEngine(timestamp) {
    const deltaTime = timestamp - this.lastTime;
    this.clock.advance(deltaTime);
    this.engine.tick(this.systemContext);
    this.lastTime = timestamp;
  }
  registerSystem(system) {
    this.engine.registerSystem(system);
  }
};
export {
  Archetype,
  ArchetypeProfile,
  ComponentData,
  ComponentFieldType, createComponent,
  createSignature, Engine,
  EntityBuilder,
  EventPriority,
  Game,
  GameWorld,
  GlobalComponentRegistry,
  Keys,
  PrefabDefinition,
  PrefabEntity,
  Query,
  System,
  TimeTracker
};
//# sourceMappingURL=index.js.map
