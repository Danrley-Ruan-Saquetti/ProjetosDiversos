type CommandListener<T = any> = (data: T) => void;
interface ICommandDomain {
    flush(): void;
}
interface ICommandDomainRegister {
    register(command: ICommandDomain): void;
}

declare enum EventPriority {
    HIGH = 0,
    NORMAL = 1,
    LOW = 2
}
type ListenerHandler<T = unknown> = (data: T) => void;
interface IEventSender {
    send(event: string, data: unknown): void;
}
interface IEventEmitter {
    emit(event: string, data: unknown): void;
}
interface IEventSubscriptionPriority {
    on(event: string, listener: ListenerHandler, priority?: EventPriority): void;
}
interface IEventUnsubscription {
    off(event: string, listener: ListenerHandler): void;
    clear(event?: string): void;
}
interface IEventListenerRegistryPriority extends IEventSubscriptionPriority, IEventUnsubscription {
}
interface IEventPublisher extends IEventSender, IEventListenerRegistryPriority {
}
type IEventSink = IEventSender;
type EventTuple = [string, unknown];

interface Input {
    isKeyHeld(key: Keys): boolean;
    isKeyDown(key: Keys): boolean;
    isKeyUp(key: Keys): boolean;
    isMouseButtonHeld(btn: number): boolean;
    isMouseButtonDown(btn: number): boolean;
    isMouseButtonUp(btn: number): boolean;
    getMouseDeltaX(): number;
    getMouseDeltaY(): number;
    getMousePositionX(): number;
    getMousePositionY(): number;
    getMouseDelta(): {
        readonly x: number;
        readonly y: number;
    };
    getMousePosition(): {
        readonly x: number;
        readonly y: number;
    };
}
interface IInputSource {
    readonly state: Input;
}
declare enum Keys {
    KeyA = "KeyA",
    KeyB = "KeyB",
    KeyC = "KeyC",
    KeyD = "KeyD",
    KeyE = "KeyE",
    KeyF = "KeyF",
    KeyG = "KeyG",
    KeyH = "KeyH",
    KeyI = "KeyI",
    KeyJ = "KeyJ",
    KeyK = "KeyK",
    KeyL = "KeyL",
    KeyM = "KeyM",
    KeyN = "KeyN",
    KeyO = "KeyO",
    KeyP = "KeyP",
    KeyQ = "KeyQ",
    KeyR = "KeyR",
    KeyS = "KeyS",
    KeyT = "KeyT",
    KeyU = "KeyU",
    KeyV = "KeyV",
    KeyW = "KeyW",
    KeyX = "KeyX",
    KeyY = "KeyY",
    KeyZ = "KeyZ",
    Digit0 = "Digit0",
    Digit1 = "Digit1",
    Digit2 = "Digit2",
    Digit3 = "Digit3",
    Digit4 = "Digit4",
    Digit5 = "Digit5",
    Digit6 = "Digit6",
    Digit7 = "Digit7",
    Digit8 = "Digit8",
    Digit9 = "Digit9",
    Minus = "Minus",
    Equal = "Equal",
    BracketLeft = "BracketLeft",
    BracketRight = "BracketRight",
    Backslash = "Backslash",
    Semicolon = "Semicolon",
    Quote = "Quote",
    Backquote = "Backquote",
    Comma = "Comma",
    Period = "Period",
    Slash = "Slash",
    Escape = "Escape",
    Enter = "Enter",
    Tab = "Tab",
    Space = "Space",
    Backspace = "Backspace",
    ShiftLeft = "ShiftLeft",
    ShiftRight = "ShiftRight",
    ControlLeft = "ControlLeft",
    ControlRight = "ControlRight",
    AltLeft = "AltLeft",
    AltRight = "AltRight",
    MetaLeft = "MetaLeft",
    MetaRight = "MetaRight",
    CapsLock = "CapsLock",
    NumLock = "NumLock",
    ScrollLock = "ScrollLock",
    ArrowUp = "ArrowUp",
    ArrowDown = "ArrowDown",
    ArrowLeft = "ArrowLeft",
    ArrowRight = "ArrowRight",
    Home = "Home",
    End = "End",
    PageUp = "PageUp",
    PageDown = "PageDown",
    Insert = "Insert",
    Delete = "Delete",
    F1 = "F1",
    F2 = "F2",
    F3 = "F3",
    F4 = "F4",
    F5 = "F5",
    F6 = "F6",
    F7 = "F7",
    F8 = "F8",
    F9 = "F9",
    F10 = "F10",
    F11 = "F11",
    F12 = "F12",
    F13 = "F13",
    F14 = "F14",
    F15 = "F15",
    F16 = "F16",
    F17 = "F17",
    F18 = "F18",
    F19 = "F19",
    F20 = "F20",
    F21 = "F21",
    F22 = "F22",
    F23 = "F23",
    F24 = "F24",
    Numpad0 = "Numpad0",
    Numpad1 = "Numpad1",
    Numpad2 = "Numpad2",
    Numpad3 = "Numpad3",
    Numpad4 = "Numpad4",
    Numpad5 = "Numpad5",
    Numpad6 = "Numpad6",
    Numpad7 = "Numpad7",
    Numpad8 = "Numpad8",
    Numpad9 = "Numpad9",
    NumpadAdd = "NumpadAdd",
    NumpadSubtract = "NumpadSubtract",
    NumpadMultiply = "NumpadMultiply",
    NumpadDivide = "NumpadDivide",
    NumpadDecimal = "NumpadDecimal",
    NumpadEnter = "NumpadEnter",
    MediaPlayPause = "MediaPlayPause",
    MediaStop = "MediaStop",
    MediaTrackNext = "MediaTrackNext",
    MediaTrackPrevious = "MediaTrackPrevious",
    VolumeMute = "VolumeMute",
    VolumeUp = "VolumeUp",
    VolumeDown = "VolumeDown",
    ContextMenu = "ContextMenu",
    PrintScreen = "PrintScreen",
    Pause = "Pause"
}

type ScheduleCallback = () => void;
interface TimerTask {
    executeAt: number;
    interval?: number;
    seq: number;
    callback: ScheduleCallback;
    cancelled?: boolean;
}

interface IScheduler {
    scheduleOnce(callback: ScheduleCallback, delay: number): TimerTask;
    scheduleRepeat(callback: ScheduleCallback, delay: number): TimerTask;
    cancel(task: TimerTask): void;
}

type DeltaTime = {
    deltaTime: number;
    deltaTimeMilliseconds: number;
    totalElapsedTime: number;
    totalElapsedTimeMilliseconds: number;
};

interface SystemInitializeContext {
    readonly world: IWorld;
    readonly events: IEventPublisher;
    readonly commands: ICommandDomainRegister;
    readonly scheduler: IScheduler;
}
interface SystemUpdateContext {
    readonly time: DeltaTime;
    readonly input: Input;
}

interface ISystem {
    initialize?(context: SystemInitializeContext): void;
    start?(): void;
    stop?(): void;
    updateBefore?(context: SystemUpdateContext): void;
    update?(context: SystemUpdateContext): void;
    updateAfter?(context: SystemUpdateContext): void;
}

declare abstract class System implements ISystem {
}

type ComponentId = bigint;
interface ComponentIdentifier {
    id: ComponentId;
}
declare enum ComponentFieldType {
    Int8 = 0,
    Uint8 = 1,
    Uint8Clamped = 2,
    Int16 = 3,
    Uint16 = 4,
    Int32 = 5,
    Uint32 = 6,
    Float16 = 7,
    Float32 = 8,
    Float64 = 9,
    BigInt64 = 10,
    BigUint64 = 11
}
type ComponentSchema = Record<string, ComponentFieldType>;
type InferSchemaValues<T extends ComponentSchema> = {
    [K in keyof T]: number;
};
interface ComponentDescriptor<TName extends string = string, TSchema extends ComponentSchema = ComponentSchema> extends ComponentIdentifier {
    name: TName;
    schema: TSchema;
}
type ComponentsToObject<T extends readonly ComponentDescriptor[] = []> = {
    [C in T[number]as C['name']]: Partial<InferSchemaValues<C['schema']>>;
};
type ComponentDataSchema = Record<string, TypedArray>;
interface IComponentData<TShape extends ComponentDataSchema = ComponentDataSchema> {
    readonly size: number;
    readonly isFull: boolean;
    readonly data: Readonly<TShape>;
    push(initialValues?: Partial<{
        [K in keyof TShape]: number;
    }>): void;
    pop(): void;
    swap(indexA: number, indexB: number): void;
    copyFrom(other: IComponentData<TShape>, index: number): void;
    field<Field extends keyof TShape>(field: Field): TShape[Field];
}

type EntityId = number;
type EntityLocation = {
    archetype: IArchetype;
    index: number;
};

type Signature = bigint;
type TypedArray = Int8Array | Uint8Array | Uint8ClampedArray | Int16Array | Uint16Array | Int32Array | Uint32Array | Float16Array | Float32Array | Float64Array | BigInt64Array | BigUint64Array;
declare enum ArchetypeProfile {
    UNIQUE = 1,
    SMALL = 8,
    COMMON = 64,
    MASSIVE = 256
}
interface IArchetype {
    readonly signature: Signature;
    readonly lastEntity: number;
    readonly size: number;
    readonly entities: EntityId[];
    initialize(initialCapacity?: number): void;
    addEntity(entityId: EntityId, initialData?: Record<number, any>): void;
    addEntityFrom(entityId: EntityId, entityIndex: number, from: IArchetype, initialData?: Record<number, any>): void;
    removeEntity(index: number): void;
    component<TName extends string, TShape extends ComponentSchema>(component: ComponentDescriptor<TName, TShape>): IComponentData<{
        [x in keyof TShape]: TypedArray;
    }>;
}

declare class ComponentRegistry {
    private schemas;
    private signatureCache;
    private nextId;
    register<TName extends string, TSchema extends ComponentSchema>(name: TName, schema: TSchema): ComponentDescriptor<TName, TSchema>;
    createComponent(id: ComponentId, initialCapacity?: number): IComponentData;
    idsFromSignature(sig: Signature): bigint[];
}
declare const GlobalComponentRegistry: ComponentRegistry;
declare function createComponent<TName extends string, TSchema extends ComponentSchema>(name: TName, schema: TSchema): ComponentDescriptor<TName, TSchema>;

declare class Archetype implements IArchetype {
    readonly signature: Signature;
    private readonly registry;
    private readonly _entities;
    private readonly components;
    private readonly componentIds;
    private readonly componentIndex;
    private initialized;
    get entities(): number[];
    get lastEntity(): number;
    get size(): number;
    constructor(signature: Signature, registry: ComponentRegistry);
    initialize(initialCapacity?: number): void;
    addEntity(entityId: EntityId, initialData?: Record<number, any>): void;
    addEntityFrom(entityId: EntityId, entityIndex: number, from: Archetype, initialData?: Record<number, any>): void;
    removeEntity(index: number): void;
    component<TName extends string, TShape extends ComponentSchema>(component: ComponentDescriptor<TName, TShape>): IComponentData<{ [x in keyof TShape]: TypedArray; }>;
}

type SchemaToData<Shape extends ComponentSchema = ComponentSchema> = {
    [K in keyof Shape]: FieldTypeToArray[Shape[K]];
};
type FieldTypeToArray = {
    [ComponentFieldType.Int8]: Int8Array;
    [ComponentFieldType.Uint8]: Uint8Array;
    [ComponentFieldType.Uint8Clamped]: Uint8ClampedArray;
    [ComponentFieldType.Int16]: Int16Array;
    [ComponentFieldType.Uint16]: Uint16Array;
    [ComponentFieldType.Int32]: Int32Array;
    [ComponentFieldType.Uint32]: Uint32Array;
    [ComponentFieldType.Float16]: Float16Array;
    [ComponentFieldType.Float32]: Float32Array;
    [ComponentFieldType.Float64]: Float64Array;
    [ComponentFieldType.BigInt64]: BigInt64Array;
    [ComponentFieldType.BigUint64]: BigUint64Array;
};
declare class ComponentData<S extends ComponentSchema = ComponentSchema, TShape extends ComponentDataSchema = SchemaToData<S>> implements IComponentData<TShape> {
    private readonly schema;
    private readonly fields;
    private _size;
    private capacity;
    get size(): number;
    get isFull(): boolean;
    get data(): TShape;
    constructor(schema: ComponentSchema, initialCapacity?: number);
    push(initialValues?: Partial<{
        [K in keyof TShape]: number;
    }>): void;
    pop(): void;
    swap(indexA: number, indexB: number): void;
    copyFrom(other: IComponentData<TShape>, index: number): void;
    field<Field extends keyof TShape>(field: Field): TShape[Field];
    private grow;
}

declare function createSignature(components: ComponentIdentifier[]): bigint;

interface IQuery {
    readonly mask: Signature;
    build(): void;
    find(max?: number): EntityId[];
    findFirst(): EntityId | undefined;
    findFirstLocation(): EntityLocation | undefined;
    count(): number;
    isEmpty(): boolean;
    has(entityId: EntityId): boolean;
    view(): readonly IArchetype[];
    onArchetypeAdded(archetype: IArchetype): void;
}

type PrefabEntityProperties = {
    profile?: ArchetypeProfile;
};
declare class PrefabEntity<TComponents extends readonly ComponentDescriptor[] = []> {
    private readonly world;
    private readonly components;
    private readonly properties;
    constructor(world: IWorld, components?: {
        component: ComponentDescriptor;
        data?: unknown;
    }[], properties?: PrefabEntityProperties);
    spawn(overrides?: Partial<ComponentsToObject<TComponents>>): number;
    getQuery(): IQuery;
}

declare class PrefabDefinition<TComponents extends readonly ComponentDescriptor[] = []> {
    private readonly components;
    private readonly properties;
    constructor(components?: {
        component: ComponentDescriptor;
        data?: unknown;
    }[], properties?: PrefabEntityProperties);
    instantiate(world: IWorld): PrefabEntity<TComponents>;
}

declare class EntityBuilder<TComponents extends readonly ComponentDescriptor[] = []> {
    private readonly properties;
    private readonly defaults;
    private readonly components;
    constructor(properties?: PrefabEntityProperties);
    with<TComponent extends ComponentDescriptor>(component: TComponent, defaultValue?: Partial<InferSchemaValues<TComponent['schema']>>): EntityBuilder<[...TComponents, TComponent]>;
    build(): PrefabDefinition<TComponents>;
}

declare class CommandDomain implements ICommandDomain {
    private readonly buffers;
    private activeBuffer;
    private readonly handlers;
    private readonly priorities;
    private get writeBuffer();
    private get readBuffer();
    constructor(maxPriority?: number);
    register(command: string, handler: CommandListener, priority?: number): void;
    send(command: string, data: unknown): void;
    flush(): void;
}

declare class QueryManager {
    private readonly world;
    private readonly queries;
    constructor(world: IWorld);
    getOrCreateQuery(components: ComponentIdentifier[]): IQuery;
    onArchetypeCreated(archetype: IArchetype): void;
}

declare class GameWorld implements IWorld {
    protected readonly commandDomain: CommandDomain;
    protected readonly queryManager: QueryManager;
    private readonly archetypes;
    private readonly entityLocation;
    private readonly entityPool;
    constructor();
    flush(): void;
    spawn({ components, profile }: IWoldSpawnProperties): number;
    destroy(entityId: EntityId): void;
    addComponent<TComponent extends ComponentDescriptor>(entityId: EntityId, component: TComponent, initialData?: ComponentsToObject<[TComponent]>): void;
    createPrefab(properties?: PrefabEntityProperties): EntityBuilder<[]>;
    getQuery(components: ComponentDescriptor[]): IQuery;
    findFirst(components: ComponentDescriptor[]): number | undefined;
    findSingleton(components: ComponentDescriptor[]): number | undefined;
    expectSingleton(components: ComponentDescriptor[]): number;
    find(components: ComponentDescriptor[]): number[];
    count(components: ComponentDescriptor[]): number;
    isEmpty(components: ComponentDescriptor[]): boolean;
    exists(components: ComponentDescriptor[]): boolean;
    hasEntity(entityId: EntityId): boolean;
    getEntityLocation(entityId: EntityId): EntityLocation | undefined;
    expectEntity(entityId: EntityId): EntityLocation;
    getArchetypes(): MapIterator<IArchetype>;
    private performCreateEntity;
    private performCreateEntityWithComponents;
    private performDestroyEntity;
    private performAddComponent;
    private moveEntity;
    private removeFromArchetype;
    private getOrCreateArchetype;
}

declare class Query implements IQuery {
    private readonly world;
    readonly mask: Signature;
    private readonly matched;
    constructor(world: IWorld, components?: ComponentIdentifier[]);
    onArchetypeAdded(archetype: IArchetype): void;
    build(): void;
    view(): readonly IArchetype[];
    find(max?: number): number[];
    findFirstLocation(): EntityLocation | undefined;
    findFirst(): number | undefined;
    count(): number;
    isEmpty(): boolean;
    has(entityId: EntityId): boolean;
    private findAll;
    private findLimited;
}

type IWoldSpawnProperties = {
    components?: {
        component: ComponentDescriptor;
        data?: unknown;
    }[];
    profile?: ArchetypeProfile;
};
interface IWorld {
    flush(): void;
    spawn(props: IWoldSpawnProperties): EntityId;
    destroy(entityId: EntityId): void;
    addComponent<TComponent extends ComponentDescriptor>(entityId: EntityId, component: TComponent, initialData?: ComponentsToObject<[TComponent]>): void;
    createPrefab(properties?: PrefabEntityProperties): EntityBuilder;
    getQuery(components: ComponentDescriptor[]): IQuery;
    findFirst(components: ComponentDescriptor[]): EntityId | undefined;
    findSingleton(components: ComponentDescriptor[]): EntityId | undefined;
    expectSingleton(components: ComponentDescriptor[]): EntityId;
    find(components: ComponentDescriptor[]): EntityId[];
    count(components: ComponentDescriptor[]): number;
    isEmpty(components: ComponentDescriptor[]): boolean;
    exists(components: ComponentDescriptor[]): boolean;
    getEntityLocation(entityId: number): EntityLocation | undefined;
    expectEntity(entityId: EntityId): EntityLocation;
    hasEntity(entityId: number): boolean;
    getArchetypes(): MapIterator<IArchetype>;
}

interface EngineInitializeContext {
    readonly world: IWorld;
    readonly scheduler: IScheduler;
}

interface IBuffer<T = any> {
    send(item: T): void;
    flush(): T[];
    size(): number;
}
interface IDispatcher<T = any> {
    dispatch(item: T): void;
}

declare class BufferConsumer<T = any> {
    protected buffer: IBuffer<T>;
    protected dispatcher?: IDispatcher<T> | undefined;
    constructor(buffer: IBuffer<T>, dispatcher?: IDispatcher<T> | undefined);
    send(item: T): void;
    execute(): void;
}

declare class DoubleBufferingConsumer<T> extends BufferConsumer<T> {
    constructor(dispatcher?: IDispatcher<T>);
}

declare class CommandScheduler {
    private readonly domains;
    register(domain: ICommandDomain): void;
    flush(): void;
}

type PriorityBucket<T = unknown> = ListenerHandler<T>[][];
type ListenersPriorityMap = {
    [K in string]?: PriorityBucket;
};
interface IEventBusPriority extends IEventListenerRegistryPriority, IEventEmitter {
}

declare class EventBusPriority implements IEventBusPriority {
    protected listeners: ListenersPriorityMap;
    on(event: string, listener: ListenerHandler, priority?: EventPriority): void;
    emit(event: string, data: unknown): void;
    off(event: string, listener: ListenerHandler): void;
    clear(event?: string): void;
}

declare class EventDispatcher implements IDispatcher<EventTuple> {
    private bus;
    constructor(bus: IEventBusPriority);
    on(event: string, listener: ListenerHandler, priority?: EventPriority): void;
    off(event: string, listener: ListenerHandler): void;
    clear(event?: string): void;
    dispatch(event: EventTuple): void;
}

declare class SystemScheduler {
    protected readonly context: SystemInitializeContext;
    private readonly systems;
    private readonly startSystems;
    private readonly stopSystems;
    private readonly updateBeforeSystems;
    private readonly updateSystems;
    private readonly updateAfterSystems;
    private isStarted;
    constructor(context: SystemInitializeContext);
    register(system: ISystem): void;
    start(): void;
    stop(): void;
    tick(context: SystemUpdateContext): void;
    private tickBefore;
    private tickUpdate;
    private tickAfter;
}

interface IEngine {
    readonly systemContext: SystemInitializeContext;
    initialize(context: EngineInitializeContext): void;
    start(): void;
    stop(): void;
    tick(context: SystemUpdateContext): void;
    registerSystem(system: ISystem): void;
    registerCommandDomain(domain: ICommandDomain): void;
    isRunning(): boolean;
}

declare class Engine implements IEngine {
    protected readonly systemScheduler: SystemScheduler;
    protected readonly commandScheduler: CommandScheduler;
    protected readonly eventBus: EventBusPriority;
    protected readonly eventDispatcher: EventDispatcher;
    protected readonly eventConsumer: DoubleBufferingConsumer<EventTuple>;
    private systemInitializeContext;
    private _isRunning;
    private isInitialized;
    get systemContext(): SystemInitializeContext;
    constructor();
    initialize(context: EngineInitializeContext): void;
    start(): void;
    stop(): void;
    tick(context: SystemUpdateContext): void;
    registerSystem(system: ISystem): void;
    registerCommandDomain(domain: ICommandDomain): void;
    isRunning(): boolean;
}

declare class MutableSystemUpdateContext implements SystemUpdateContext {
    time: DeltaTime;
    input: Input;
}

declare class InputSystem extends System implements IInputSource {
    private readonly _state;
    get state(): Input;
    start(): void;
    stop(): void;
    update(): void;
    private onKeyDown;
    private onKeyUp;
    private onMouseDown;
    private onMouseUp;
    private onMouseMove;
    private onBlur;
}

declare class SchedulerSystem extends System {
    private scheduler;
    private elapsedTime;
    update(context: SystemUpdateContext): void;
    scheduleOnce(callback: ScheduleCallback, delay: number): TimerTask;
    scheduleRepeat(callback: ScheduleCallback, interval: number): TimerTask;
    cancel(task: TimerTask): void;
}

interface ITimeSource {
    readonly time: Readonly<DeltaTime>;
}
interface ITimerTrackerController {
    reset(): void;
    advance(milliseconds: number): void;
}
interface ITimerTracker extends ITimeSource, ITimerTrackerController {
}

declare class Game {
    protected readonly engine: IEngine;
    protected readonly world: IWorld;
    protected readonly clock: ITimerTracker;
    protected readonly systemContext: MutableSystemUpdateContext;
    protected readonly inputSystem: InputSystem;
    protected readonly schedulerSystem: SchedulerSystem;
    private timeout;
    private lastTime;
    constructor();
    start(): void;
    protected initializeEngine(): void;
    protected initialize(): void;
    stop(): void;
    protected update: (timestamp: number) => void;
    private updateEngine;
    registerSystem(system: ISystem): void;
}

declare class TimeTracker implements ITimerTracker {
    protected totalElapsedTime: number;
    protected deltaTime: number;
    protected _time: DeltaTime;
    get time(): DeltaTime;
    reset(): void;
    advance(milliseconds: number): void;
    private updateState;
    getState(): DeltaTime;
}

export { Archetype, ArchetypeProfile, ComponentData, ComponentFieldType, createComponent, createSignature, Engine, EntityBuilder, EventPriority, Game, GameWorld, GlobalComponentRegistry, Keys, PrefabDefinition, PrefabEntity, Query, System, TimeTracker, type CommandListener, type ComponentDataSchema, type ComponentDescriptor, type ComponentId, type ComponentIdentifier, type ComponentSchema, type DeltaTime, type EngineInitializeContext, type EntityId, type EntityLocation, type IArchetype, type ICommandDomain, type ICommandDomainRegister, type IComponentData, type IEventEmitter, type IEventListenerRegistryPriority, type IEventPublisher, type IEventSender, type IEventSink, type IEventSubscriptionPriority, type IEventUnsubscription, type IInputSource, type Input, type IQuery, type IScheduler, type ISystem, type ITimerTracker, type ITimerTrackerController, type ITimeSource, type IWoldSpawnProperties, type IWorld, type ListenerHandler, type PrefabEntityProperties, type Signature, type SystemInitializeContext, type SystemUpdateContext, type TimerTask, type TypedArray };

