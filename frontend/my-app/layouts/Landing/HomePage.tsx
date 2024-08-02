import { LandingPageMainPicture } from "../../assets/LandingPageMainPicture";

export const HomePage = () => {
    return (
        <div className="grid grid-cols-1 gap-y-6 gap-x-6 md:grid-cols-2 justify-items-center text-center lg:text-end">
            <h1 className="max-w-80 leading-snug col-span-1 text-5xl font-bold md:justify-self-end md:self-center lg:self-end">
                Plan Meals. Track Cals.
                <span className="text-primary"> Crush Goals.</span>
            </h1>
            <p className="col-span-1 text-xl max-w-96 mx-12 md:col-span-2 md:row-start-2 lg:mx-0 lg:justify-self-end lg:col-start-1 lg:col-end-1">
                Demeter is your personal nutrition assistant designed to make healthy eating easy, accessible,
                and sustainable so that you can spend more time doing the things you love.
            </p>
            <a className="btn btn-lg btn-wide btn-primary md:col-span-2 md:row-start-3 lg:justify-self-end lg:col-start-1 lg:col-end-1">Get Started</a>
            <div className="col-span-1 md:col-start-2 md:col-end-3 md:row-start-1 md:justify-self-start md:self-center lg:row-start-1 lg:row-end-4">
                <LandingPageMainPicture />
            </div>
        </div>
    );
}